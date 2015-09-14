/*
Challenge 231 (easy): Cellular automata rule 90
----------------------------------------------
This program reads a binary string from the user and applies the rule that each
digit in an iteration is the XOR of the digit's neighbours in the previous iteration.

Takes arguments
- input (binary string to apply pattern to)
- length (number of iterations in pattern)
*/
import java.util.Scanner;
import java.util.regex.Pattern;
public class c231e{
  public static void main(String[] args) {
    int searchArray=0;
    String inputString="";
    int length=10;
    while(searchArray<args.length){ //reads input from arguments
      if (args[searchArray].toLowerCase().equals("-input")){
        inputString=args[searchArray+1];
      }
      else if(args[searchArray].toLowerCase().equals("-length")){
        length=Integer.parseInt(args[searchArray+1]);
      }
      searchArray++;
    }
    Pattern checkBinary=Pattern.compile(".*[^01].*");
    if (inputString.equals("")||checkBinary.matcher(inputString).matches()){ //if no arguments presented, reads input from user
      Scanner in = new Scanner(System.in);
      do{
        System.out.println("Please enter a binary number of at least 10 digits. Binary numbers must only contain 0s and 1s.");
        inputString=in.next().trim();
      }while (inputString.equals("")||checkBinary.matcher(inputString).matches());
    }

    for (char digit:inputString.toCharArray()){ //prints input as first line of pattern
      if (digit=='1') {
        System.out.print("X");
      }
      else if(digit=='0'){
        System.out.print(" ");
      }
      //System.out.print(digit+"  ");
    }
    System.out.println();
    int iterations=1;
    do{//loops through (length) iterations of the pattern
      searchArray=0;
      String outputString="";
      do {//loops through string to form new string, calls out to formNextCell subroutine
          outputString+=formNextCell(inputString,searchArray);
          searchArray++;
      } while (searchArray<inputString.length());

      for (char digit:outputString.toCharArray()){ //prints output for this line
        if (digit=='1') {
          System.out.print("X");
        }
        else if(digit=='0'){
          System.out.print(" ");
        }
        //System.out.print(digit+"  ");
      }
      System.out.println();
      inputString=outputString;//resets strings to be used again in next iteration of loops
      outputString="";
      iterations++;
    }while(iterations<=length);
  }

  public static String formNextCell(String input, int pos){
    int leftNeighbour; //defines left and right values for XOR operation
    if (pos==0){
      leftNeighbour=0;
    }
    else{
      leftNeighbour=Integer.parseInt(input.substring(pos-1,pos));
    }
    int rightNeighbour;
    if(pos==input.length()-1){
      rightNeighbour=0;
    }
    else{
      rightNeighbour=Integer.parseInt(input.substring(pos+1,pos+2));
    }
    String output;
    if (leftNeighbour!=rightNeighbour){//XOR evaluation
      return "1";
    }
    else{
      return "0";
    }
  }
}
