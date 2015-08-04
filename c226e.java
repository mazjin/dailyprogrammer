import java.util.Scanner;
public class c226e{

  public static int getNumer(String fraction){
    int divisorPos=fraction.indexOf("/");
    String numerString=fraction.substring(0,divisorPos);
    return Integer.valueOf(numerString);
  }
  public static int getDenom(String fraction){
    int divisorPos=fraction.indexOf("/");
    String denomString=fraction.substring(divisorPos+1);
    return Integer.valueOf(denomString);
  }
  public static String addFractions(int numer1, int denom1, int numer2, int denom2){
    int finalDenom = denom1*denom2;
    numer1=numer1*denom2;
    numer2=numer2*denom1;
    int finalNumer=numer1+numer2;
    int gcd=greatestCommonDivisor(finalNumer,finalDenom);
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
    System.out.println("Final fraction = "+totalFraction);
  }
  public static int greatestCommonDivisor(int num1, int num2){
    int remainder=num1%num2;
    while (remainder!=0){
      num1=num2;
      num2=remainder;
      remainder=num1%num2;
    }
    return num2;
  }
