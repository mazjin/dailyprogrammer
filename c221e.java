import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class c221e{
  public static void main(String[] args) {
    String test="";
    char[][] output; //2d array to form grid for characters
    String[] wordsIn; // array formed from input
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to the Word Snakifier. Please enter your words.");
    System.out.println("Please bear in mind that the word snake must consist of words that chain together by the last and first letters, seperated by spaces e.g. essence erect together -> essencerectogether");
    String input = in.nextLine();
    input=input.trim();
    input=input.toUpperCase();
    int size=input.length()/2;
    output=new char[size][size]; //initialise output array
    for (char[] row:output){//fills empty grid with dots for spacing
      Arrays.fill(row,'.');
    }
    wordsIn=input.split(" ");//forms input array
    char[] currWord; //current word being operated on as a character array
    int x=0;//x position in array/on grid
    int y=0; //y position in array/on grid
    int dir=1; //defines direction words will form on grid in, 0=right,1=up,2=down,3=left
    Random rand = new Random(); //instantiates random number generator
    for (String item : wordsIn){
      System.out.println(item);
      currWord=item.toCharArray();
      test=in.nextLine();
      dir=generateDir(dir,item.length(),x,y,output,size);
      test=in.nextLine();
      System.out.println(".");
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
      else if (dir==3){ //forms word left to right
        for (char letter: currWord){
          output[y][x]=letter;
          x--;
        }
        x++; //takes position on grid back to that of last letter; letters must "chain" as part of challenge
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
  public static int generateDir(int dirIn,int wordLength, int currX,int currY,char[][] output,int size){ //generates new direction value based on current direction & position and length of current word
    Random rando = new Random();
    int dirOut=dirIn;
    //if ((currX==0)&&(currY==0)){return 0;}
    //else{
      while(collisionDet(dirOut,currX,currY,wordLength,output,size)){
        dirOut=rando.nextInt(4);
        System.out.println(dirOut);
      }
    //}
    return dirOut;
  }
  public static boolean collisionDet(int checkDir,int currX,int currY,int length, char[][] output,int size){
    int xIncrement=0;
    int yIncrement=0;
    int xPos=currX;
    int yPos=currY;
    String test="";
    Scanner in=new Scanner(System.in);
    boolean collided=false;
    boolean yoob=false;
    boolean xoob=false;
    switch (checkDir){
      case 0: xIncrement=1;
      case 1: yIncrement=-1;
      case 2: yIncrement=1;
      case 3: xIncrement=-1;
    }
    while((xPos<currX+length)&&(yPos<currY+length)){
      yoob=(yPos<0);
      yoob=yoob || (yPos>=size);
      xoob=(xPos<0);
      xoob=xoob || (xPos>=size);
      if (xoob||yoob){
        collided=true;
        //break;
      }
      else if (String.valueOf(output[yPos][xPos]).equals(".")){
        collided=true;
        //break;
      }
      xPos=xPos+xIncrement;
      yPos=yPos+yIncrement;
      System.out.println(collided);
      test=in.nextLine();
    }
    return collided;
  }
}
