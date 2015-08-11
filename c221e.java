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
    String input = in.nextLine(); //reads input
    input=input.trim();
    input=input.toUpperCase();
    int size=input.length()/2; //sets size of array based on input string
    output=new char[size][size]; //initialise output array
    for (char[] row:output){//fills empty grid with dots for spacing
      Arrays.fill(row,'.');
    }
    wordsIn=input.split(" ");//forms input array
    char[] currWord; //current word being operated on as a character array
    int x=0;//x position in array/on grid
    int y=0; //y position in array/on grid
    int dir=1; //defines direction words will form on grid in, 0=right,1=up,2=down,3=left
    for (String item : wordsIn){
      currWord=item.toCharArray();
      dir=generateDir(dir,item.length(),x,y,output,size);
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
      else{
        System.out.println("Snake attempted to eat itself! Feed it a more varied diet of words!");
        break;
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
    int dirOut=dirIn;
    boolean coll=true;
    boolean[] tried = new boolean[4]; //tracks directions attempted so as to avoid infinite loops if trapped
    Arrays.fill(tried,false);
    boolean[] quitCondition = new boolean[4]; //array to check direction tracker against
    Arrays.fill(quitCondition,true);
    if ((currX==0)&&(currY==0)){return 0;}//sets initial word to go right as specified in challenge
    else{
      do {
        tried[dirOut]=true;//marks direction as attempted
        dirOut=compass(dirIn);//sets direction based on previous
        coll=collisionDet(dirOut,currX,currY,wordLength,output,size); //collision detection
        if (coll&&(tried.equals(quitCondition))){return 5;} //exit condition if trapped
      }while(coll);
    }
    return dirOut;
  }
  public static boolean collisionDet(int checkDir,int currX,int currY,int length, char[][] output,int size){
    int xIncrement=0; //amount to change x by (+1 if right, -1 if left)
    int yIncrement=0; //amount to change y by (+1 if down, -1 if up)
    int xPos=currX; //position being checked
    int yPos=currY;
    boolean collided=false;
    switch (checkDir){ //selects appropriate behaviour to check in required direction
      case 0: xIncrement=1;
              xPos++;
              break;
      case 1: yIncrement=-1;
              yPos--;
              break;
      case 2: yIncrement=1;
              yPos++;
              break;
      case 3: xIncrement=-1;
              xPos--;
              break;
    }
    do{
      if (((xPos<0) || (xPos>=size))||((yPos<0)|| (yPos>=size))){//checks for collision with edge/outside of grid
        collided=true;
        break;
      }
      else if (!String.valueOf(output[yPos][xPos]).equals(".")){//checks for collision with characters
        collided=true;
        break;
      }
      xPos=xPos+xIncrement; //progress across grid
      yPos=yPos+yIncrement;
    }while(((yPos<currY+length-1)&&(yPos>currY-length+1)) && ((xPos<currX+length-1)&&(xPos>currX-length+1))); //checks x and y being checked are inside grid
    return collided;
  }
  public static int compass(int dir){ //selects direction based on previous
    Random rando = new Random();//creates pseudorandom number generator
    int out=rando.nextInt(2); //generates direction integer = 0 or 1 randomly
    switch (dir){
      case 0:
              out=out+1; //sets to 1(up) or 2(down)
              break;
      case 1:
              out=out*3;//sets to 0(right) or 3(left)
              break;
      case 2:
              out=out*3;
              break;
      case 3:
              out=out+1;
              break;
    }
    return out;
  }
}
