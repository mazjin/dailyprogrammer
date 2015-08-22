public class c228e{
  public static void main(String[] args) {
    String[] testWords={"almost","cereal","billowy","biopsy","chinos","defaced","chintz","sponged","bijoux","abhors","fiddle","begins","chimps","wronged"};
    if (args.length==0){
      checkListForAlphabeticals(testWords);
    }
    else{checkListForAlphabeticals(args);}
  }
  public static void checkListForAlphabeticals(String[] wordsIn){
    for (String s : wordsIn){
      System.out.println(s+ "\n alphabetical: "+isAlpha(s,false)+"\n   reverse alphabetical: "+isAlpha(s,true));
    }
  }
  public static boolean isAlpha(String in,boolean isReversed){
    String alphabetical="abcdefghijklmnopqrstuvwxyz";
    int prevLetterPos=0;
    int currLetterPos=0;
    boolean isAlphabetical=true;
    int i;
    if (isReversed){i=in.length()-1;}
    else{i=0;}
    do{
      prevLetterPos=currLetterPos;
      currLetterPos=alphabetical.indexOf(in.charAt(i));
      if (currLetterPos<prevLetterPos){isAlphabetical=false;}
      if (isReversed){i--;}
      else{i++;}
    }while(i<in.length()&&i>=0);
    return isAlphabetical;
  }
}
