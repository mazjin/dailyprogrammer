
def powerset(iterable):
	"""returns tuple of tuples containing every combination of factors in the iterable entered"""
	import itertools
	s=list(iterable)
	return itertools.chain(itertools.combinations(s,r) for r in range(len(s)+1))

def subsets(s):
	"""returns list of sets of tuples containing all unique combinations of factors in iterable entered"""
	return list(map(set,powerset(s)))
	
def integerComplexityTest(input):
	"""returns the smallest possible value for B+C, where the input value is A and A=B*C"""
	import time,math
	from operator import mul
	from functools import reduce
	start_time=time.time()
	if len(input)==1:
		#handles main case and bonus 1
		input=int(input[0])
		b=None
		c=None
		"""starting from square root and counting down, find highest integer factor to use as B, then divide input by B to get C"""
		for i in range(math.ceil(input**0.5),1,-1):
			if input%i==0:
				b=i
				c=input/i
				break
	else:
		# bonus 2 code, code and functions largely taken from /u/hube19's answer
		
		#get original number and square root
		num=reduce(mul,input,1)
		root=math.ceil(num**0.5)
		
		if root in input:
			b=c=root
		else:
			#get list of tuples containing all unique combinations of factors
			sub=subsets(input)
			sub.pop(0)
			sub=[list(i) for i in sub]
			total=[]
			for i in sub:
				total+=i
			
			#get distances of each tuple's product from root
			prod=[abs(reduce(lambda x,y:x*y,i,1)-root) for i in total]
			
			#get factors corresponding to closest value, then get closest value and other factor
			closest=total[prod.index(min(prod))]
			b=reduce(mul,closest,1)
			c=num/b
	if b and c:
		print("B="+str(b))
		print("C="+str(c))
		print("B+C="+str(b+c))
	else:
		print(str(input) + " is prime!")
	print("found in %s seconds" % (time.time()-start_time))
	
def main():
	import sys
	input=sys.argv[1:]
	input=[int(i) for i in input]
	input.sort()
	integerComplexityTest(input)
	
if __name__=="__main__":main()

	
	