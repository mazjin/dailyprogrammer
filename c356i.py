''' Challenge 365 (intermediate): Goldbach's Weak Conjecture
Uses Sieve of Eratosthenes approach to create list of primes, then simply brute-
forces for possible solutions (unsure if analytic solutions exist, given lack of
a strong proof).''' 

from math import sqrt

def eratosthenes_sieve(lim):
    primes=list(range(2,lim))
    for i in range(2,max(int(sqrt(lim)),5)):
        for n in primes[::-1]:
            if n%i==0 and n/i!=1:
                primes.pop(primes.index(n))
    return primes

def c356i(n):
    primes=eratosthenes_sieve(n-4)
    triples=[]
    for p in primes:
        for q in primes:
            if n-p-q in primes:
                triple=sorted((p,q,n-p-q))
                if triple not in triples: triples.append(triple)
    yield triples

def main():
    for val in [111,17,199,287,53]:
        print("Goldbach triples of "+str(val)+":")
        print(*c356i(val))
if __name__=="__main__":
    main()
