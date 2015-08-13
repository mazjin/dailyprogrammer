
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class c223e{
  public static int garland(String wordIn) {
    String startChars="";
    String endChars="";
    String matchChars="";
    int i=0;
    int degree=0;
      for (i=1; i<wordIn.length(); i++){
          startChars=wordIn.substring(0,i);
          endChars=wordIn.substring((wordIn.length()-i),(wordIn.length()));
          if (startChars.equals(endChars)){
            matchChars=startChars;
            degree=startChars.length();
            break;
          }
      }
      return degree;
  }
  public static void main(String[] args) throws IOException{
    System.out.println("Welcome to the Garland word checker.");
    Scanner in=new Scanner(System.in);
    String checkWord;
    do {
      System.out.println("Please enter either a word to check, any number to find the garland word rankings by degree, or nothing if you wish to exit), and press enter.");
      if (in.hasNextInt()){
        rankings();
        break;
      }
      else{
        checkWord = in.nextLine();
      }
      if (checkWord.isEmpty()){
        break;
      }
      else {
        System.out.println("Word " + checkWord+ "has degree " + challenge223e.garland(checkWord));
      }
    }while (checkWord!="");

  }
  public static String garlandChain(String wordIn, int degree){
    Scanner in=new Scanner(System.in);
    do {
      System.out.println("Please enter the desired length of the chain as an integer.");
    }while(!in.hasNextInt());
    int chainLength = in.nextInt();
    int i;
    String chain="";
    for (i=chainLength; i>0;i--){
      if (chain.isEmpty()){
        chain=wordIn;
      }
      else {
        chain=chain+wordIn.substring(degree,wordIn.length());
      }
    }
    return chain;
  }
  public static void rankings() throws IOException{
    FileReader fr = new FileReader("c223egerman.dic");
    BufferedReader textReader = new BufferedReader(fr);
    String line;
    String largestWords="";
    int largestDegree=0;
    do {
        line=textReader.readLine();
        if (line==null){
          break;
        }
        if (garland(line)>largestDegree)
        {
          largestDegree=garland(line);
          largestWords=line;
          System.out.println(largestWords +" = " +largestDegree);
        }
        else if (garland(line)==largestDegree)
        {
          largestWords=largestWords + " , " + line;
        }
      }while (line!=null);
    System.out.println("The largest garland word(s), with a degree of "+ largestDegree+": "+ largestWords);
  }
}
