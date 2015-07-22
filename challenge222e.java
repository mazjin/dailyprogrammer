
import java.util.Scanner;
public class challenge222e{
  public static void garland(String wordIn) {
    String startChars="";
    String endChars="";
    String matchChars="";
    int i=0;
    int degree=0;
      for (i=1; i<wordIn.length(); i++){
          startChars=wordIn.substring(0,i);
          endChars=wordIn.substring((wordIn.length()-i),(wordIn.length()));
          System.out.println(startChars+","+ endChars);
          if (startChars.equals(endChars)){
            matchChars=startChars;
            degree=startChars.length();
            break;
          }
      }
      if (degree==0){
        System.out.println("No matches found, "+wordIn+" must not be a Garland word.");
      }
      else {
        System.out.println("'" +wordIn+ "' is a Garland word of degree " + degree +", (starts and ends with "+ matchChars+")");
      }

  }
  public static void main(String[] args){
    System.out.println("Welcome to the Garland word checker.");
    Scanner in=new Scanner(System.in);
    String checkWord;
    do {
      System.out.println("Please enter your word,(or nothing if you wish to exit), and press enter.");
      checkWord = in.nextLine();
      if (checkWord.isEmpty()){
        break;
      }
      else {
        garland(checkWord);
      }
    }while (checkWord!="");

  }
}
