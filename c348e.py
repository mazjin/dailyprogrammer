'''Challenge 348 (easy): The Rabbit Problem
Rabbits represented as a list for each gender, using the age in months as an
index, with each item in the list being a integer counting the number of rabbits
currently at that age. As bonus, also tracks number of deaths and allows own
variables to be entered instead of defaults given in challenge.
'''

def c348e(init_males,init_females,target_pop,init_age=2,fertile_age=4,males_born=5,
    females_born=9, life_expectancy=96):
    males=[0 for x in range(life_expectancy)]
    females=[0 for x in range(life_expectancy)]
    dead=0
    males[init_age]=init_males
    females[init_age]=init_females
    months_passed=0
    while sum(males)+sum(females)<target_pop:
        birth_events=sum(females[fertile_age:])
        dead+=females[-1]+males[-1]
        males=[birth_events*males_born]+males[:-1]
        females=[birth_events*females_born]+females[:-1]
        months_passed+=1
        # if months_passed%12==0:
        #     print("Year "+str(int(months_passed/12)))
        #     print(males)
        #     print(females)
    return months_passed, sum(males)+sum(females),dead

def main():
    c1=c348e(2,4,1000000000)
    print("Challenge input 1 : After "+str(c1[0])+" months, "+str(c1[1]) +\
        " bunnies, with "+str(c1[2])+" deaths.")

    c2=c348e(2,4,15000000000)
    print("Challenge input 2 : After "+str(c2[0])+" months, "+str(c2[1]) +\
        " bunnies, with "+str(c2[2])+" deaths.")

if __name__=="__main__":
    main()
