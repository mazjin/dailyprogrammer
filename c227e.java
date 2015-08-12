import java.util.Scanner;
import java.util.Arrays;
public class c227e{
  public static void main(String[] args) {
    char[][] grid;
    Scanner in = new Scanner(System.in);
    int s;
    do{
      System.out.println("Enter spiral size S");
    }while(!in.hasNextInt());
    s=in.nextInt();
    grid=new char[(2*s)-1][(2*s)-1];
    for (char[] row : grid){
      Arrays.fill(row,' ');
    }
    for (int j=0;j>=(2*s)-1;j=j+2){
      for (int i=0;i>=(2*s)-1;i=i+2){
        grid[j][i]='+';
      }
    }
    grid[s][s]='X';
    String outputLine="";
    for (char[] row : grid){
      for (char letter : row){
        outputLine=outputLine+String.valueOf(letter);
      }
      System.out.println(outputLine);
      outputLine="";
    }
  }
}
