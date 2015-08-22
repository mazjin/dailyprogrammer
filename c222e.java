public class c222e{
  public static void main(String[] args) {
    String[] testWords={"STEAD","CONSUBSTANTIATION","WRONGHEADED","UNINTELLIGIBILITY","SUPERGLUE"};
    if (args.length==0){
      balanceWordList(testWords);
    }
    else{
      balanceWordList(args);
    }
  }
  public static void balanceWordList(String[] inputArr){
    int balancePoint;
    for (String s: inputArr){
      balancePoint=balance(s);
      if (balancePoint!=0){
        System.out.println(s +" balances at point "+(balancePoint+1)+", on "+s.charAt(balancePoint));
        System.out.print(String.format("%1$"+(balancePoint+1)+"s","^"));
        System.out.println();
      }
      else{
        System.out.println(s+" doesn't have a define balance point.");
      }
    }
  }
  public static int balance(String input){
    int balancePoint=0;
    int i=1;
    do {
      if (isBalancedOn(i,input)){
        balancePoint=i;
        return balancePoint;
      }
      i++;
    } while (i<input.length()-1);
    return balancePoint;
  }
  public static boolean isBalancedOn(int position,String input){
    String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int beforeLetterWeight=0;
    int afterLetterWeight=0;
    int i=0;
    do {
      beforeLetterWeight+=(alphabet.indexOf(input.charAt(i)+1)*(position -i));
      i++;
    } while (i<position);
    i=position+1;
    do {
      afterLetterWeight+=(alphabet.indexOf(input.charAt(i)+1)*(i-position));
      i++;
    } while (i<input.length());
    return beforeLetterWeight==afterLetterWeight;
  }
}
