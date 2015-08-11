import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class c221e{
  public static void main(String[] args) {
    char[][] output; //2d array to form grid for characters
    String[] wordsIn; // array formed from input
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to the Word Snakifier. Please enter your words.");
    System.out.println("Please bear in mind that the word snake must consist of words that chain together by the last and first letters, seperated by spaces e.g. essence erect together -> essencerectogether");
    String input = in.nextLine();
    input=input.trim();
    input=input.toUpperCase();
    int size=input.length();
    output=new char[size/2][size/2]; //initialise output array
    for (char[] row:output){//fills empty grid with dots for spacing
      Arrays.fill(row,'.');
    }
    wordsIn=input.split(" ");//forms input array
    char[] currWord; //current word being operated on as a character array
    int x=0;//x position in array/on grid
    int y=0; //y position in array/on grid
    int dir=1; //defines direction words will form on grid in, 0=right,1=up,2=down
    Random rand = new Random(); //instantiates random number generator
    for (String item : wordsIn){
      currWord=item.toCharArray();
      dir=generateDir(dir,item.length(),y);
      if (dir==0){ //forms word left to right
        for (char letter: currWord){
          output[y][x]=letter;
          x++;
        }
        x--; //takes position on grid back to that of last letter; letters must "chain" as part of challenge
      }
      else if (dir==1){ //forms word upwards
        for (char letter:currWord){
          output[y][x]=letter;
          y--;
        }
        y++; //takes position back as above
      }
      else if (dir==2){ //forms word downwards
        for (char letter:currWord){
          output[y][x]=letter;
          y++;
        }
        y--; //takes position back as above
      }
    }
    String printString=""; //prints grid row by row as a string
    for (char[] row : output){
      for (char letter : row){
        printString=printString+String.valueOf(letter);
      }
      System.out.println(printString);
      printString=""; //resets string
    }
  }
  public static int generateDir(int dirIn,int wordLength, int currY){ //generates new direction value based on current direction & position and length of current word
    Random rando = new Random();
    int dirOut=0;
    if (dirIn==0){
      while ((dirOut==0)||((dirOut==1)&&(wordLength>=currY))){// collision detection with upper edge of grid
        dirOut=rando.nextInt(3);
        //System.out.println("gen:"+dirOut);
      }
    }
    //else{System.out.println("gen:"+dirOut);}
  return dirOut;
  }
}
