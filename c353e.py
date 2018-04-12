
def main():
    import sys

    n=int(sys.argv[1])
    strings=sys.argv[2:]
    if len(strings)!=n:
        raise ValueError("Number of inputs does not match n!")
    distances=[]
    for i,s in enumerate(strings):
        score=0
        for j, ss in enumerate(strings):
            if i!=j:
                score+=dist(s,ss)
        print(s,score)
        distances.append(score)
        if score==min(distances):
            current_min=s
    print(current_min)

def dist(s1,s2):
    if len(s1)!=len(s2):
        raise ValueError("Strings are not the same length!")
    dist=0
    for i in range(len(s1)):
        if s1[i]!=s2[i]:
            dist+=1
    return dist

if __name__=="__main__":main()
