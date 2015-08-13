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
    if (s%2==0){
      s++;
      System.out.println("S needs to be an odd number, setting to "+s+" instead");
    }
    grid=new char[(2*s)-1][(2*s)-1];
    grid=fillGrid(grid,s);
    grid[s][s]='X';
    printGrid(grid);
  }


  public static char[][] fillGrid(char[][] grid, int s){
    int count=0;
    for (char[] row : grid){
      count=0;
      //Arrays.fill(row,' ');
      for (char letter : row){
        System.out.println("col " + count%2);
        if (count%2==0){
          letter='+';
        }
        else{
          letter=' ';
        }
        count++;
      }
    }
    /*for (int j=0;j>=(2*s)-1;j++){
      for (int i=0;i>=(2*s)-1;i++){
        if ((i%2==0)&&(j%2==0)){
          System.out.println("BLONK");
          grid[j][i]='+';
        }
      }
    }*/
    return grid;
  }



  public static void printGrid(char[][] grid){

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
