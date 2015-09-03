import java.util.Scanner;
import java.io.*;
public class c209e{
  public static void main(String[] args) throws IOException{
    int[] flairs;
    String file="c09efile.txt";
    if (args.length==0){
      Scanner in= new Scanner(System.in);
      do {
        System.out.println("Please enter a file to read data from.");
      } while (!in.hasNext());
      file=in.next();
    }
    else{
      file=args[0];
    }
    FileReader fr =new FileReader(file);
    BufferedReader read = new BufferedReader(fr);
    int numOfUsers=Integer.parseInt(read.readLine().trim());
    System.out.println(numOfUsers);
    double[] times=new double[numOfUsers];
    String[] names=new String[numOfUsers];
    String name="";
    double time=60d;
    String readIn;
    String tempName="";
    double tempTime=0d;
    int i=0;
    int linecount=1;
    boolean empty=true;
    do {
      readIn=read.readLine();
      System.out.println(readIn);
      if (readIn==null){break;}
      name=readIn.substring(0,readIn.indexOf(":")).trim();
      System.out.println(name);
      time=Double.parseDouble(readIn.substring(readIn.indexOf(":")+1).trim());
      System.out.println(time);
      i=0;
      for (double tim : times){
        tim=315569660d;
      }
      do {
        if (times[i]>time){
          tempTime=times[i];
          tempName=names[i];
          times[i]=time;
          names[i]=name;
          time=tempTime;
          name=tempName;
          empty=false;
        }
        i++;
      } while (i<numOfUsers);
      if (empty){
        times[0]=time;
        names[0]=name;
        empty=false;
      }
      System.out.println(empty);
      linecount++;
    } while (linecount<=numOfUsers);
    i=0;
    do {
      System.out.println(names[i]+" at "+times[i]);
      i++;
    } while (i<numOfUsers);
  }
}
