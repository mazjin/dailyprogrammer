import java.util.Scanner;
public class c226e{

  public static long getNumer(String fraction){
    int divisorPos=fraction.indexOf("/");
    String numerString=fraction.substring(0,divisorPos);
    return Long.valueOf(numerString);
  }
  public static long getDenom(String fraction){
    int divisorPos=fraction.indexOf("/");
    String denomString=fraction.substring(divisorPos+1);
    return Long.valueOf(denomString);
  }
  public static String addFractions(long numer1, long denom1, long numer2, long denom2){
    long finalDenom = denom1*denom2;
    numer1=numer1*denom2;
    numer2=numer2*denom1;
    long finalNumer=numer1+numer2;
    long gcd=greatestCommonDivisor(finalNumer,finalDenom);
    finalNumer=finalNumer/gcd;
    finalDenom=finalDenom/gcd;
    return finalNumer+"/"+finalDenom;
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int noFractions=0;
    do{
      System.out.println("Please enter the number of fractions to be added.");
      if (in.hasNextInt()){
        noFractions=in.nextInt();
      }
    }while(noFractions==0);
    String[] fractionsArray=new String[noFractions];
    int i=0;
    while (i<noFractions) {//(i=0;i==noFractions;i++){
      System.out.println("Please enter fraction number "+(i+1));
        fractionsArray[i]=in.next();
      i++;
    }
    String totalFraction=fractionsArray[0];
    i=1;
    while(i<noFractions) {//for(i=1;i==noFractions;i++){
      totalFraction=addFractions(getNumer(totalFraction),getDenom(totalFraction),getNumer(fractionsArray[i]),getDenom(fractionsArray[i]));
      i++;
    }
    String mixed=mixedFraction(totalFraction);
    System.out.println("Final fraction = "+totalFraction);
    if (!mixed.equals(totalFraction)){
      System.out.println("as a mixed fraction, "+ mixed);
    }
  }
  public static long greatestCommonDivisor(long num1, long num2){
    long remainder=num1%num2;
    while (remainder!=0){
      num1=num2;
      num2=remainder;
      remainder=num1%num2;
    }
    return num2;
  }
  public static String mixedFraction(String frac){
    long num=getNumer(frac);
    long denom=getDenom(frac);
    long mixedInt=0;
    if (num>denom){
      mixedInt=num/denom;
      num=num%denom;
    }
    long gcd=greatestCommonDivisor(num,denom);
    num=num/gcd;
    denom=denom/gcd;
    if (mixedInt==0){return frac;}
    else{return mixedInt+" "+num+"/"+denom;}
  }
}
