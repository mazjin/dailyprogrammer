public class c214e{
  public static void main(String[] args) {
    if (args.length==0){
      double[] inArray={5d,6d,11d,13d,19d,20d,25d,26d,28d,37d};
      System.out.println(getStdDev(inArray));
    }
    else{
      double[] inArray=new double[args.length];
      int i=0;
      do {
        inArray[i]=Double.parseDouble(args[i]);
        i++;
      } while (i<args.length);
      System.out.println(getStdDev(inArray));
    }
  }
  public static double getStdDev(double[] inArray){
    double sum=0;
    for (double d:inArray){
      sum+=d;
    }
    double mean=sum/inArray.length;
    double sumOfSquares=0;
    double meanDiff;
    for (double d: inArray){
      meanDiff=Math.abs(d-mean);
      sumOfSquares+=(meanDiff*meanDiff);
    }
    double variance=sumOfSquares/inArray.length;
    return Math.sqrt(variance);
  }
}
