import java.util.Scanner;
import java.io.*;
public class c209e{
  public static void main(String[] args) throws IOException{
    int[] flairs;
    String file="c209efile.txt";
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
    double prev=0;
    for (double tim : times){
      tim=315569660d;
    }
    do {
      readIn=read.readLine();
      System.out.println(readIn);
      if (readIn==null){break;}
      name=readIn.substring(0,readIn.indexOf(":")).trim();
      time=Double.parseDouble(readIn.substring(readIn.indexOf(":")+1).trim());
      i=numOfUsers-1;
      do {
        if (times[i]<time){
          tempTime=times[i];
          tempName=names[i];
          times[i]=time;
          names[i]=name;
          time=tempTime;
          name=tempName;
        }
        i--;
      } while (i>=0);
      linecount++;
    } while (linecount<=numOfUsers);
    i=0;
    do {
      System.out.println(names[i]+" at "+times[i]);
      i++;
    } while (i<numOfUsers);
    i=0;
    do {
      tempTime=(int)60-(times[i]-prev);
      System.out.println(tempTime);
      prev=times[i];
      times[i]=tempTime;
      i++;
    } while (i<numOfUsers);
    i=0;
    do {
      System.out.println(names[i]+" got flair "+(int)times[i]);
      i++;
    } while (i<numOfUsers);
  }
}
