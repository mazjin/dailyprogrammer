'''Challenge 359 (easy): Paper fold sequence
Sequence is always symmetrical: the output at any given step is simply
the output from the previous step reflected (both in order and in binary value
in the output of the first step (1). Function below recursively calculates from
n=1.
'''
def c359e(num_cycles):
    if num_cycles==1:return "1"
    else:
        prev=c359e(num_cycles-1)
        opp=prev[::-1].replace("0","x").replace("1","0").replace("x","1")
        return prev+"1"+opp

def main():
    for i in range(1,9):
        print(c359e(i))

if __name__=="__main__":
    main()
