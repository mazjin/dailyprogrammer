'''Challenge 344 (easy): Baum-Sweet Sequence
Solution using regular expressions on binary strings. Could likely shave this
down to a line or two using proper list comprehensions, may come back and update
this.
'''

def c344e(n):
    import re
    p=re.compile("0+")
    seq={0:1}
    for i in range(1,n):
        b=bin(i)
        seq[i]=1
        for m in p.findall(b[2:]):
            if len(m)%2==1:
                seq[i]=0
                break
    return list(seq.values())

def main():
    print(c344e(20))

if __name__=="__main__":
    main()
