import java.util.Scanner;
import java.util.Arrays;
public class c227e{
  public static void main(String[] args) {
    long[][] grid;
    Scanner in = new Scanner(System.in);
    int s;
    String searchString="";
    long searchLong=0;
    do{
      System.out.println("Enter spiral size S");
    }while(!in.hasNextInt());
    s=in.nextInt();
    if (s%2==0){
      s++;
      System.out.println("S needs to be an odd number, setting to "+s+" instead");
    }
    do{
      System.out.println("Enter a positive number for a clockwise spiral, or a negative for an anticlockwise spiral");
    }
    while(!in.hasNextInt());
    int spiralDirection=in.nextInt();
    if (spiralDirection<0){
      spiralDirection=-1;
    }
    else{spiralDirection=1;}
    do{
      System.out.println("Enter a single value to find in the spiral(eg. 49), or the coordinates to check in the spiral(eg. (1,5))");
    }while (!in.hasNext());
    /*if (in.hasNextInt()){
      System.out.println("single int");
      searchInt=in.nextInt();
    }
    else{
      System.out.println("coords");
      */searchString=in.next();
    //}
    grid=new long[s][s];
    grid=fillGrid(grid,s,spiralDirection);
    printGrid(grid);
    if (searchString.matches(".*\\D+.*")){
      System.out.println("coords");
      searchString=searchString.trim();
      System.out.println(searchString);
      String[] searchCoords=searchString.split("\\D");
      int x=Integer.parseInt(searchCoords[0]);
      int y=Integer.parseInt(searchCoords[1]);
      System.out.println("search coords are "+x+","+y);
      System.out.println(findInSpiral(grid,s,x,y));
    }
    else if (searchString==""){
      System.out.println("Empty search string!");
    }
    else{
      System.out.println("integer");
      searchLong=Long.parseLong(searchString.trim());
      System.out.println("search integer is "+searchLong);
      System.out.println(findInSpiral(grid,s,searchLong));
    }
  }


  public static long[][] fillGrid(long[][] grid, int s, int spiralDirection){
    for (long[] row : grid){
      Arrays.fill(row,0);
    }
    int i=(s-1)/2;
    int j=(s-1)/2;
    long count=1;
    int dir=0;
    int armLength=1;
    int armDistance=0;
    do{
        //System.out.println(i+","+j+","+dir+","+armDistance+","+armLength);
        grid[j][i]=count;
        switch (dir){
          case 0:
            i=i+spiralDirection;
            break;
          case 1:
            j=j-spiralDirection;
            break;
          case 2:
            i=i-spiralDirection;
            break;
          case 3:
            j=j+spiralDirection;
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
    }while (count<=(s*s));

    return grid;
  }

  public static String findInSpiral(long[][] grid, long s, long searchLong){
    int xPos=0;
    int yPos=0;
      while (yPos<=(s-1)){
        while (xPos<=(s-1)){
          //System.out.println(xPos+","+yPos+"="+grid[yPos][xPos]);
          if (grid[yPos][xPos]==searchLong){
            return ("Found "+searchLong+" at position ("+(xPos+1)+","+(yPos+1)+")");
          }
          xPos++;
        }
        xPos=0;
        yPos++;
      }

    return ("Search did not find " + searchLong + " in the spiral. Sorry!");
  }
  public static String findInSpiral(long[][] grid, long s, int xPos,int yPos){
      long searchValue=grid[yPos-1][xPos-1];
      return ("Found "+searchValue+" at position ("+(xPos)+","+(yPos)+")");
  }
  public static void printGrid(long[][] grid){

    String outputLine="";
    for (long[] row : grid){
      for (long value : row){
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
