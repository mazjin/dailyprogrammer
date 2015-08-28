import java.io.*;
public class c217e{
  public static void main(String[] args) throws IOException{
    String file;
    if (args.length!=0){file=args[0];}
    else{file="c217efile.txt";}
    FileReader fr = new FileReader(file);
    BufferedReader reader=new BufferedReader(fr);
    int gridSize=Integer.parseInt(reader.readLine());
    int logsToStack=Integer.parseInt(reader.readLine());
    int[][] logPiles = new int[gridSize][gridSize];
    String[] strInput = new String[gridSize];
    String lineReadIn;
    int i=0;
    int j=0;
    System.out.println("grid size:"+gridSize);
    System.out.println("No. logs: "+logsToStack);
    do {
      j=0;
      lineReadIn=reader.readLine().trim();
      strInput=lineReadIn.split("[ ]{1,2}");
      do {
        if (!strInput[j].isEmpty()){
          logPiles[i][j]=Integer.parseInt(strInput[j]);
          j++;
        }
      } while (j<gridSize);
      i++;
    } while (i<gridSize);
    int smallest=0;
    do {
      smallest=findSmallestPile(logPiles);
      //System.out.println("smallest: "+smallest);
      i=0;
      do {
        j=0;
        do {
          if (logPiles[i][j]==smallest){
            logPiles[i][j]++;
            logsToStack--;
          }
          if (logsToStack<=0){break;}
          j++;
        } while (j<gridSize);
        if (logsToStack<=0){break;}
        i++;
      } while (i<gridSize);
    } while (logsToStack>0);
    System.out.println();
    for (int[] col : logPiles){
      for (int point: col){
        System.out.print(point+" ");
      }
      System.out.println();
    }
  }
  public static int findSmallestPile(int[][] gridPiles){
    int smallest=42949672;
    for (int[] col : gridPiles){
      for (int point:col){
        if (smallest>point){smallest=point;}
      }
    }
    return smallest;
  }
}
