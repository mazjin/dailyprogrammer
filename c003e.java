import java.util.Scanner;
import java.util.Arrays;
public class c003e{
  public static void main(String[] args) {
    System.out.println("Welcome to the Caesar Cipher!\nPlease enter 'e' or 'd' to encode or decode, followed by the number of the shift (eg 3 spaces a->d, -2 spaces e->b), followed by the string to encode");
    Scanner in=new Scanner(System.in);
    String input=in.nextLine().trim();
    String[] inputArr = input.split(" ");
    int shiftAmount=Integer.parseInt(inputArr[1]);
    String words="";
    int i=2;
    do{
      words=words+" "+inputArr[i];
      i++;
    }while(i<inputArr.length);
    boolean encode=(inputArr[0].toLowerCase().equals("e"));
    if (encode){
      System.out.println(code(words,shiftAmount));
    }
    else if (!encode){
      System.out.println(code(words,(shiftAmount*-1)));
    }
  }
  public static String code(String input, int shiftAmount){
    char[] inputCharArr=input.toCharArray();
    String output="";
    for (char letter : inputCharArr){
      output=output+String.valueOf(shift(letter,shiftAmount));
    }
    return output;
  }
  public static char shift(char c,int shift){
    String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    c=Character.toUpperCase(c);
    if (alphabet.indexOf(c)==-1){
      return c;
    }
    else{
      int i=alphabet.indexOf(c);
      i=i+shift;
      if (i>=26){i=i-26;}
      if (i<0){i=i+26;}
      return alphabet.charAt(i);
    }
  }
}
