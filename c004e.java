import java.util.Random;
public class c004e{
  public static void main(String[] args) {
    int noPasswords=Integer.parseInt(args[0]);
    int length=Integer.parseInt(args[1]);
    for (int i=0;i<noPasswords;i++){
      generatePassword(i,length);
    }
  }

  public static void generatePassword(int seed,int length){
    String alph="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"£$%^&*()_+";
    Random rn=new Random(seed);
    int i = 0;
    do{
      System.out.print(alph.charAt(rn.nextInt(alph.length())));
      i++;
    }while(i<length);
    System.out.println();
  }
}
