'''Challenge 344 intermediate: Banker's Algorithm
Uses numpy arrays to represent available resources as vector and task
allocations/requirements as matrices to take advantage of vector
addition/subtractions. Would like to implement a solution for the
bonus challenge - maybe a recursive approach possible? Need to come back to this
'''

def c344i(path):#num_inputs=5):
    import numpy as np
    # available=np.array(input().split(),dtype=int)
    # mat=np.array([input().split() for x in range(num_inputs)],dtype=int)
    with open(path,'r') as file:
        lines=file.readlines()
    available=np.array(lines[0].replace("\n","").split(),dtype=int)
    mat=np.array([lines[x].replace("\n","").split() \
        for x in range(1,len(lines))],dtype=int)
    num_inputs=len(mat)
    alloc=mat[:,:3]
    max=mat[:,3:]
    needed=max-alloc
    done=[False for x in range(num_inputs)]
    seq=[]
    while not all(done):
        possible=[True if all([True if (needed[x]-available)[i]<=0 else False \
            for i in range(len(available))]) and not done[x] else False \
            for x in range(num_inputs)]
        if not any(possible):
            print("Not enough resources to tackle remaining tasks!")
            for x in range(num_inputs):
                print("Task "+str(x)+": %s" %("Complete" if done[x]\
                    else "Incomplete"))
            break
        incentive=[sum(alloc[x]) if possible[x] \
            else False for x in range (num_inputs)]
         #sum of resources freed up by completing task
        task_chosen=np.argmax(incentive)
        done[task_chosen]=True
        seq.append(task_chosen)
        available+=alloc[task_chosen]
    return seq

if __name__=="__main__":
    print(c344i('c344i_input.txt'))
