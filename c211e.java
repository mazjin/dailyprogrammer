import java.util.Scanner;
public class c211e{
  public static void main(String[] args) {
    String name="";
    if (args.length==0){
      Scanner in = new Scanner(System.in);
      do {
        System.out.println("Please enter your name to play the name game!");
      } while (!in.hasNext());
      name=in.next();
    }
    else{
      name=args[0];
    }
      if (name.charAt(name.length()-1)=='!'){
        name=name.substring(0,name.length()-1);
      }
      System.out.println();
      System.out.print(name+", "+name+" bo");
      System.out.print(alterName(name,'B'));
      System.out.print(name.substring(1)+",\n");
      System.out.print("Bonana fanna fo ");
      System.out.print(alterName(name,'F'));
      System.out.print(name.substring(1)+",\n");
      System.out.print("Fee fy mo");
      System.out.print(alterName(name,'M'));
      System.out.print(name.substring(1)+",\n");
      System.out.println(name+"!");
  }
  public static String alterName(String nameIn, char replaceChar){
    if(nameIn.charAt(0)==replaceChar){
      return ("-");
    }
    else if(String.valueOf(nameIn.charAt(0)).matches("[aeiouAEIOU]")){
      return (" "+replaceChar+Character.toLowerCase(nameIn.charAt(0)));
    }
    else{
      return (" "+replaceChar);
    }
  }
}
