import java.util.Scanner;
import java.util.Arrays;
public class c212ebonus{
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    String toDecode="Wowelolcocomome toto tothohe Rorövovarorsospoproråkoketot totroranonsoslolatotoror!";
    System.out.println(toDecode);
    do { //input loop, exited when empty input is entered
        System.out.println(toNormal(toDecode));
        System.out.println("Please enter a sentence/word to decode!");
        toDecode=in.nextLine();
    } while (!toDecode.isEmpty());
  }
  public static boolean isAVowel(char letter){
    char[] vowels={'a','e','i','o','u','y','å','ä','ö','A','E','I','O','U','Å','Ä','Ö'}; //list of vowels to check against
    boolean foundInVowels=false; //output boolean
    for (char vowel : vowels){ //reads through vowels list and checks input character against each
      if (vowel==letter){
        foundInVowels=true;
        break;
      }
    }
    return foundInVowels;
  }
  public static String toNormal(String input){ //translation subroutine
    String output=""; //output string, will contain translated string
    int i=0; //index position
    do { //loops through input string character by character
      output=output+String.valueOf(input.charAt(i));
      if (!isAVowel(input.charAt(i)) && i+2<input.length() && input.charAt(i+1)=='o' && input.charAt(i+2)==Character.toLowerCase(input.charAt(i))&& Character.isLetter(input.charAt(i))){
        i=i+2; //if consonant pattern is found, skips next two letters (as they are the o and twin consonant added when translating TO Rovarspraket)
      }
      i++; //iterates loop
    } while (i<input.length());
    return output;
  }
}
