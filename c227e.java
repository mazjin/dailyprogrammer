import java.util.Scanner;
import java.util.Arrays;
public class c227e{
  public static void main(String[] args) {
    int[][] grid;
    Scanner in = new Scanner(System.in);
    int s;
    String searchString="";
    int searchInt=0;
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
    grid=new int[s][s];
    grid=fillGrid(grid,s,spiralDirection);
    printGrid(grid);
    if (searchString.matches(".*\\D+.*")){
      System.out.println("coords");
      searchString=searchString.trim();
      //searchString=searchString.substring(1,-1);
      System.out.println(searchString);
      String[] searchInts=searchString.split("\\D");
      int x=Integer.parseInt(searchInts[0]);
      int y=Integer.parseInt(searchInts[1]);
      System.out.println("search coords are "+x+","+y);//+","+searchInts[1]);
      System.out.println(findInSpiral(grid,s,x,y));
    }
    else if (searchString==""){
      System.out.println("Empty search string!");
    }
    else{
      System.out.println("integer");
      searchInt=Integer.parseInt(searchString.trim());
      System.out.println("search integer is "+searchInt);
      System.out.println(findInSpiral(grid,s,searchInt));
    }
  }


  public static int[][] fillGrid(int[][] grid, int s, int spiralDirection){
    for (int[] row : grid){
      Arrays.fill(row,0);
    }
    int i=(s-1)/2;
    int j=(s-1)/2;
    int count=1;
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

  public static String findInSpiral(int[][] grid, int s, int searchInt){
    int xPos=0;
    int yPos=0;
      while (yPos<=(s-1)){
        while (xPos<=(s-1)){
          //System.out.println(xPos+","+yPos+"="+grid[yPos][xPos]);
          if (grid[yPos][xPos]==searchInt){
            return ("Found "+searchInt+" at position ("+(xPos+1)+","+(yPos+1)+")");
          }
          xPos++;
        }
        xPos=0;
        yPos++;
      }

    return ("Search did not find " + searchInt + " in the spiral. Sorry!");
  }
  public static String findInSpiral(int[][] grid, int s, int xPos,int yPos){
      int searchValue=grid[yPos-1][xPos-1];
      return ("Found "+searchValue+" at position ("+(xPos)+","+(yPos)+")");
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
