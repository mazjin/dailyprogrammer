import java.util.ArrayList;
public class c215e{
  public static void main(String[] args) {
    if (args.length==0){
      System.out.println("Syntax: java c215e n [b]\n n is the starting number of the cycle\n b (optional) is the power or base of the sad cycle, default 3");
    }
    else{
      String numString=args[0];
      System.out.print(numString);
      int base;
      ArrayList<String> sequence = new ArrayList<String>(1);
      sequence.add(numString);
      if (args.length>1){
        base=Integer.parseInt(args[1]);
      }
      else{
        base=3;
      }
      int length=0;
      do {
        numString=getSadNumber(numString,base);
        sequence.add(numString);
        System.out.print(","+numString);
        length=getSequenceLength(sequence);
      } while (length==0);
      printSadCycle(sequence,length);
    }
  }
  public static String getSadNumber(String inString,int b){
    long num=0l;
    //char[] inArr = inString.toCharArray();
    int n=0;
    do {
      num+=(long) Math.pow(Double.parseDouble(inString.substring(n,n+1)),b);
      n++;
    } while (n<inString.length());
    return ""+num;
  }
  public static int getSequenceLength(ArrayList<String> sequence){
    int currentNumIndex=sequence.size()-1;
    int i=currentNumIndex-1;
    int length =0;
    do {
      if (sequence.get(i).equals(sequence.get(currentNumIndex))){
        length=currentNumIndex - i;
        if (i-length>0){
          if (sequence.get(currentNumIndex).equals(sequence.get(i-length))){
            return length;
          }
        }
      }
      i--;
    } while (i>=0);
    return 0;
  }
  public static void printSadCycle(ArrayList<String> sequence,int length){
    System.out.println("\nFound cycle as:");
    int i=sequence.size()-1 -length;
    do {
      System.out.print(sequence.get(i));
      i++;
      if (i<sequence.size()-1){System.out.print(", ");}
    } while (i<sequence.size()-1);
    System.out.println();
  }
}
