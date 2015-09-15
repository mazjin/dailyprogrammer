/*
Challenge 005 (easy) : L
*/
import java.util.Scanner;
import java.io.*;
public class c005e{
  public static void main(String[] args) {
    int searchPos=0;
    String usernameEntered="";
    String passwordEntered="";
    Boolean setUserPassword=false;
    do { //reads arguments from command line
      if (args.length==0){
        break;
      }
      if (args[searchPos].equals("-u")||args[searchPos].equals("-user")||args[searchPos].equals("-username")){
        usernameEntered=args[searchPos+1];
      }
      if (args[searchPos].equals("-pw")||args[searchPos].equals("-pass")||args[searchPos].equals("-password")){
        passwordEntered=args[searchPos+1];
      }
      if (args[searchPos].equals("-s")||args[searchPos].equals("-set")){
        setUserPassword=true;
      }
      searchPos++;
    } while (searchPos<args.length);

    Scanner in = new Scanner(System.in);//reads info from user if not previously found or doesn't satisfy length requirements
    while (usernameEntered.length()<=3){
      System.out.println("Please enter a username 4 or more characters in length.");
      usernameEntered=in.nextLine();
    }
    while(passwordEntered.length()<=3){
      System.out.println("Please enter a password of 4 or more characters in length.");
      passwordEntered=in.nextLine();
    }
    if (setUserPassword){ //writes new password to file
      try (Writer write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c005eusers.txt"),"utf-8"))){
        write.write(usernameEntered+"\n");
        write.write(passwordEntered);
      }
      catch(IOException ex){
        System.out.println("An error occurred writing to file! "+ex);
      }
      System.out.println("Your username ("+usernameEntered+") and password ("+passwordEntered+") have been saved.");
    }
    else{ //reads info from file
      String usernameRecorded="";
      String passwordRecorded= "";
      try(BufferedReader read = new BufferedReader(new FileReader("c005eusers.txt"))){
        usernameRecorded = read.readLine();
        passwordRecorded = read.readLine();
      }
      catch(IOException ex){
        System.out.println("An error occurred while reading user information! "+ex);
      }
      if ((usernameRecorded.equals(usernameEntered))&&(passwordRecorded.equals(passwordEntered))){ //verifies info entered against info in file
        System.out.println("Log-in details verified."); //successful Log-in
        System.out.println();
        System.out.println();
        System.out.println("Welcome "+usernameRecorded);
      }
      else{
        System.out.println("Sorry, your log-in details could not be verified."); //unsuccessful log-in
      }
    }
  }
}
