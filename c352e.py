'''Challenge 352 (easy): Making Imgur-style links
Recursive solution that defaults to given alphanumeric symbols and base62,
but can be modified to accept a shorter alphanumeric base or a longer base
(given a longer set of symbols)'''


from string import digits,ascii_letters
alphanum=digits+ascii_letters
def c352e(n, base=62, symbols=alphanum):
    if n==0:
        return "0"
    else:
        return c352e(n//base).lstrip("0")+symbols[n%base]

def main():
    print(c352e(187621))
    print(c352e(237860461))
    print(c352e(2187521))
    print(c352e(18752))

if __name__=="__main__":
    main()
