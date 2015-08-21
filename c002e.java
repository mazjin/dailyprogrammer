import java.util.Scanner;
public class c002e{
  public static void main(String[] args) {
    System.out.println("Welcome to the Explore Learning wage calculator!\nPlease enter either the number of hours worked, then your rate separated by a space to calculate your wage owed, or enter an amount in decimal currency, then your rate separated by a space to calculate the number of hours worked.");
    Scanner in=new Scanner(System.in);
    String input=in.nextLine().trim();
    String[] inputArr=input.split(" ");
    int hours;
    float rate;
    float wage;
    if (inputArr[0].indexOf(".")==-1){
      hours=Integer.parseInt(inputArr[0]);
      rate=Float.parseFloat(inputArr[1]);
      wage=calc(hours, rate);
      System.out.println("For working "+hours+" hours at "+rate+" per hour, with holiday pay at 12%, you are owed £"+wage+".");
    }
    else {
      wage=Float.parseFloat(inputArr[0]);
      rate=Float.parseFloat(inputArr[1]);
      hours=calc(wage,rate);
      System.out.println("To earn £"+wage+", you would have to work for "+hours+" hours at a rate of "+rate+" per hour.");
    }
  }
  public static float calc(int hours, float rate){
    float output=(hours*rate)*1.12f;
    output=Math.round(output*100f)/100f;
    return output;
  }
  public static int calc(float wage, float rate){
    return Math.round((wage/1.12f)/rate);
  }
}
