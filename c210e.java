import java.util.Scanner;
public class c210e{
  public static void main(String[] args) {
    long numA=0;
    long numB=0;
    if (args.length!=2){
      System.out.println("No valid arguments entered.");
      Scanner in = new Scanner(System.in);
      do {
        System.out.println("Please enter the first number to match");
      } while (!in.hasNextLong());
      numA=in.nextLong();
      do {
        System.out.println("Please enter the second number to match");
      } while (!in.hasNextLong());
      numB=in.nextLong();
    }
    else{
    numA=Long.parseLong(args[0]);
    numB=Long.parseLong(args[1]);
    }
    String binaryA=getBinary(numA);
    String binaryB=getBinary(numB);
    System.out.println("Numbers "+numA+" and "+numB+" have "+getMatchPercentage(binaryA,binaryB)+"% compatibility");
    System.out.println(numA+" should avoid "+getOpposite(binaryA));
    if (numA!=numB){
      System.out.println(numB+" should avoid "+getOpposite(binaryB));
    }
  }
  public static String getBinary(long num){
    String binary=Long.toBinaryString(num);
    while (binary.length()<32){
      binary="0"+binary;
    }
    return binary;
>>>>>>> master
  }
  public static double getMatchPercentage(String binaryA,String binaryB){
    int i=0;
    double compatibility=0;
    do {
      System.out.println(binaryA+" "+binaryB+" "+i);
      if (binaryA.charAt(i)==binaryB.charAt(i)){
        compatibility++;
      }
      i++;
    } while (i<binaryA.length());
    compatibility=compatibility/binaryA.length();
    compatibility=compatibility*100;
    return compatibility;
  }
  public static long getOpposite(String binary){
    int i = 0;
    String binaryOut="";
    do {
      if (binary.charAt(i)=='1'){
        binaryOut+="0";
      }
      else if (binary.charAt(i)=='0'){
        binaryOut+="1";
      }
      i++;
    } while (i<binary.length());
    return (Long.parseLong(binaryOut,2));
  }
}
