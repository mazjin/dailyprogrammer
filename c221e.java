import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class c221e{
  public static void main(String[] args) {
    char[][] output;
    String[] wordsIn;
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to the Word Snakifier. Please enter your words.");
    System.out.println("Please bear in mind that the word snake must consist of words that chain together by the last and first letters, seperated by spaces e.g. essence erect together -> essencerectogether");
    String input = in.nextLine();
    input=input.trim();
    input=input.toUpperCase();
    int size=input.length();
    output=new char[size][size];
    for (char[] row:output){
      Arrays.fill(row,'.');
    }
    wordsIn=input.split(" ");
    char[] currWord;
    int x=0;
    int y=0;
    int dir=0; //0=right,1=up,2=down
    Random rand = new Random();
    for (String item : wordsIn){
      System.out.println(item);
      currWord=item.toCharArray();
      for (char letter : currWord){
        System.out.println(letter);
      }
      if (dir==0){
        for (char letter: currWord){
          output[y][x]=letter;
          x++;
        }
        x--;
        if (y<item.length()){dir=2;}
        else{
          while(dir==0){
            dir=rand.nextInt(2);
          }
        }
      }
      else if (dir==1){
        for (char letter:currWord){
          output[y][x]=letter;
          y--;
        }
        y++;
        dir=0;
      }
      else if (dir==2){
        for (char letter:currWord){
          output[y][x]=letter;
          y++;
        }
        y--;
        dir=0;
      }
    }
    String printString="";
    for (char[] row : output){
      for (char letter : row){
        printString=printString+String.valueOf(letter);
      }
      System.out.println(printString);
      printString="";
    }
  }
}
