public class c213e{
  public static void main(String[] args) {
    if (args.length==0){
      System.out.println("Please include hex value as an argument");
    }
    else{
      String hexValue=args[0];
      String pronouncableHex=getPronunciation(hexValue);
      System.out.println(hexValue+" is read as "+pronouncableHex);
    }
  }
  public static String getPronunciation(String inputHex){
    char[] characters = inputHex.substring(2).toCharArray();
    String output="";
    int pos=0;
    do {
      if (pos!=0&&pos%2==0){output+=" ";}
      output+=pronounce(characters[pos],pos%2==0);
      if (pos%2!=0 && pos+1<characters.length && characters[pos]!='0'){
        output+=" bitey";
      }
      else if(pos%2==0){output+="-";}
      pos++;
    } while (pos<characters.length);
    return output;
  }
  public static String pronounce(char inChar,boolean tens){
      if (tens){
        switch(inChar){
        case '0':return "";
        case '1':return "ten";
        case '2':return "twenty";
        case '3':return "thirty";
        case '4':return "forty";
        case '5':return "fifty";
        case '6':return "sixty";
        case '7':return "seventy";
        case '8':return "eighty";
        case '9':return "ninety";
        case 'A':return "atta";
        case 'B':return "bibbity";
        case 'C':return "city";
        case 'D':return "dickety";
        case 'E':return "ebbity";
        case 'F':return "fleventy";
      }}
      else{
        switch(inChar){
        case '0':return "bitey";
        case '1':return "one";
        case '2':return "two";
        case '3':return "three";
        case '4':return "four";
        case '5':return "five";
        case '6':return "six";
        case '7':return "seven";
        case '8':return "eight";
        case '9':return "nine";
        case 'A':return "ay";
        case 'B':return "bee";
        case 'C':return "cee";
        case 'D':return "dee";
        case 'E':return "ee";
        case 'F':return "eff";

      }
    }
    return "";
  }
}
