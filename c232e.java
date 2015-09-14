import java.util.Scanner;
public class c232e{
  public static void main(String[] args) {
    int searchArray=0;
    String inputString="";
    while(searchArray<args.length){ //reads input from arguments
      if (args[searchArray].toLowerCase().equals("-input")||args[searchArray].toLowerCase().equals("-i")){
        inputString=args[searchArray+1];
      }
      searchArray++;
    }
    if (inputString.equals("")){ //reads input from user if arguments inconclusive
      Scanner in = new Scanner(System.in);
      do{
        System.out.println("Please enter a string to check for palindromicity");
      }while(!in.hasNext());
      inputString=in.nextLine();
    }
    String usedInputString=squish(inputString).toLowerCase(); //removes punctuation and unwanted characters from the string used for palindromic analysis
    String firstHalf=usedInputString.substring(0,(usedInputString.length()+1)/2);
    String lastHalf=getReversedLastHalf(usedInputString);
    if (firstHalf.equals(lastHalf)){ // actual palindromicity check
      System.out.println("Yes, \""+inputString+"\" is palindromic.");
    }
    else{
      System.out.println("No, \""+inputString+"\" is not palindromic.");
    }
  }
  public static String squish(String input){ //removes punctuation and whitespace from string
    String output="";
    for (char ch : input.toCharArray()){ //loops through String
        if (String.valueOf(ch).toLowerCase().matches("[abcdefghijklmnopqrstuvwxyz]")){
          output+=ch;
        }
    }
    return output;
  }
  public static String getReversedLastHalf(String input){ //loops through String backwards to middle to form possible unit of reversal
    int pos=input.length()-1;
    String output="";
    do {
      output+=input.charAt(pos);
      pos--;
    } while (pos>(input.length()/2)-1);
    return output;
  }
}
