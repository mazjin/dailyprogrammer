import java.util.Scanner;
import java.util.Arrays;
public class c212e{
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    String toTranslate="Welcome to the Rövarspråket translator!";
    System.out.println(toTranslate);
    do {
        System.out.println(toRS(toTranslate));
        System.out.println("Please enter a sentence/word to translate!");
        toTranslate=in.nextLine();
    } while (!toTranslate.isEmpty());
  }
  public static String toRS(String input){
    char[] letters=input.toCharArray();
    String output="";
    for (char letter : letters){
      if ((!isAVowel(letter))&&(Character.isLetter(letter))){
        output=output+String.valueOf(letter)+"o"+String.valueOf(letter).toLowerCase();
      }
      else{
        output=output+String.valueOf(letter);
      }
    }
    return output;
  }
  public static boolean isAVowel(char letter){
    char[] vowels={'a','e','i','o','u','y','å','ä','ö','A','E','I','O','U','Å','Ä','Ö'};
    boolean foundInVowels=false;
    for (char vowel : vowels){
      if (vowel==letter){
        foundInVowels=true;
        break;
      }
    }
    return foundInVowels;
  }
}
