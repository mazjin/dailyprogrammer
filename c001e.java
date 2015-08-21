import java.util.Scanner;
import java.io.*;
public class c001e{
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    String name;
    do{
      System.out.println("Please enter your name.");
    }while(!in.hasNext());
    name=in.nextLine();
    int years;
    do{
      System.out.println("Please enter your age in whole years");
    }while(!in.hasNextInt());
    years=in.nextInt();
    String username;
    do{
      System.out.println("Please enter your reddit username.");
    }while (!in.hasNext());
    username=in.next();
    String confirm;
    do{
      System.out.println("So, your name is "+name+", you are "+years+" years old, and your reddit username is "+username+". Is this correct, Y/N?");
      confirm=in.next().trim();
      confirm=confirm.toUpperCase();
    }while(!confirm.equals("Y") && !confirm.equals("N"));
    if (confirm.equals("N")){
      System.out.println("Oops! I must have made a mistake! Try and tell me again.");
    }
    else if (confirm.equals("Y")){
      System.out.println("Good! We will store this information for you.");
    }
    try (Writer write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c001eoutput.txt"),"utf-8"))){
      write.write("name:"+name+"\n");
      write.write("age:"+years+"\n");
      write.write("username:"+username+"\n");
    }
    catch(IOException ex){
      System.out.println("An error occurred writing to file!");
    }
  }
}
