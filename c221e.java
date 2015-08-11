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
    for (String item : wordsIn){
      //System.out.println(item);
      currWord=item.toCharArray();
      //test=in.nextLine();
      dir=generateDir(dir,item.length(),x,y,output,size);
      //test=in.nextLine();
      //System.out.println(".");
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
        System.out.println("Snake attempted to eat itself");
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
    boolean[] tried = new boolean[4];
    Arrays.fill(tried,false);
    boolean[] quitCondition = new boolean[4];
    Arrays.fill(quitCondition,true);
    if ((currX==0)&&(currY==0)){return 0;}
    else{
      do {
        tried[dirOut]=true;
        dirOut=compass(dirIn);
        coll=collisionDet(dirOut,currX,currY,wordLength,output,size);
        if (coll&&(tried.equals(quitCondition))){return 5;}
        System.out.println(coll+","+dirOut+","+currX+","+currY);
      }while(coll);
    }
    return dirOut;
  }
  public static boolean collisionDet(int checkDir,int currX,int currY,int length, char[][] output,int size){
    int xIncrement=0;
    int yIncrement=0;
    int xPos=currX;
    int yPos=currY;
    //String test="";
    //Scanner in=new Scanner(System.in);
    boolean collided=false;
    boolean yoob=false;
    boolean xoob=false;
    switch (checkDir){
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
    boolean eoy=false;
    boolean eox=false;
    do{
      eoy=(yPos>currY+length-1)||(yPos<currY-length+1);
      eox=(xPos>currX+length-1)||(xPos<currX-length+1);
      yoob=(yPos<0);
      yoob=yoob || (yPos>=size);
      xoob=(xPos<0);
      xoob=xoob || (xPos>=size);
      if (xoob||yoob){
        collided=true;
        //System.out.println("OOB at "+xPos+","+yPos);
        break;
      }
      else if (!String.valueOf(output[yPos][xPos]).equals(".")){
        //System.out.println("char at "+xPos+","+yPos);
        collided=true;
        break;
      }
      xPos=xPos+xIncrement;
      yPos=yPos+yIncrement;
      System.out.println(collided+","+xPos+","+yPos);
    }while(!eoy && !eox);
    return collided;
  }
  public static int compass(int dir){
    Random rando = new Random();
    int out=rando.nextInt(2);

    switch (dir){
      case 0:
              out=out+1;
              break;
      case 1:
              out=out*3;
              break;
      case 2:
              out=out*3;
              break;
      case 3:
              out=out+1;
              break;
    }
    System.out.println(dir+" -> "+out);
    return out;
  }
}
