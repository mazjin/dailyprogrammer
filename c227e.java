import java.util.Scanner;
import java.util.Arrays;
public class c227e{
  public static void main(String[] args) {
    int[][] grid;
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
    grid=new int[s][s];
    grid=fillGrid(grid,s);
    printGrid(grid);
  }


  public static int[][] fillGrid(int[][] grid, int s){
    for (int[] row : grid){
      Arrays.fill(row,0);
    }
    int i=(s-1)/2;
    int j=(s-1)/2;
    int count=0;
    int dir=0;
    int armLength=1;
    int armDistance=0;
    do{
        System.out.println(i+","+j+","+dir+","+armDistance+","+armLength);
        grid[j][i]=count;
        switch (dir){
          case 0:
            i++;
            break;
          case 1:
            j--;
            break;
          case 2:
            i--;
            break;
          case 3:
            j++;
            break;

        }
        armDistance++;
        if (armDistance>=armLength){
          if (dir%2!=0){armLength++;}
          dir++;
          armDistance=0;
        }
        if (dir>=4){dir=0;}
        count++;
    }while (count<(s*s));

    return grid;
  }



  public static void printGrid(int[][] grid){

    String outputLine="";
    for (int[] row : grid){
      for (int value : row){
        if (value<10){
          outputLine=outputLine+0+value+" ";
        }
        else{
          outputLine=outputLine+value+" ";
      }
      }
      System.out.println(outputLine);
      outputLine="";
    }
  }
}
