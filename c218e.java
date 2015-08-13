public class c218e{
  long number;
  int steps;
  public static void main(String[] args) {
    new c218e(11);
    new c218e(68);
    new c218e(123);
    new c218e(286);
    new c218e(196196871);
  }
  public c218e(long num){
    number=num;
    steps=0;
    long max = 3223372036854775809L;
    long rev;
    while ((!isPalindromic(number))&&(number<=max)){
      rev=reverseNum(number);
      //System.out.println(number+" + "+rev+" = "+(number+rev));
      number=number+rev;
      steps++;
      if (number>=max){break;}
    }
    if (isPalindromic(number)){
      System.out.println(num + " becomes palindromic ("+number+") in "+steps+"steps.");
    }
    else{
      System.out.println(num+" did not become palindromic after "+steps+" steps");
    }
  }

  public static boolean isPalindromic(long num){
    String numString=""+num;
    int len=numString.length();
    String firstHalf=numString.substring(0,(len+1)/2);
    String secondHalf=numString.substring(len/2,len);
    secondHalf=reverseStr(secondHalf);
    //System.out.println("first:" + firstHalf +", second:"+secondHalf);
    return secondHalf.equals(firstHalf);
  }

  public static String reverseStr(String input){
    String output="";
    char[] inputArr = input.toCharArray();
    for (char letter:inputArr){
      output=String.valueOf(letter)+output;
    }
    //System.out.println(input+ " -> "+output);
    return output;
  }

  public static long reverseNum(long input){
    String inputStr=""+input;
    String outputStr=reverseStr(inputStr);
    long output=Long.parseLong(outputStr);
    return output;
  }


}
