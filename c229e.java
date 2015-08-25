public class c229e{
  public static void main(String[] args) {
    if (args.length==0){System.out.println("Syntax: java c229e N [P] [F]\nN = Starting number\nP (optional) = precision as a negative pwoer of ten (e.g 3=1/1000)\n F (optional) = Function to use, D for Dottie Number, P for Pi, G for Golden Ratio, L for logistic map.");}
    else{
      Double number =Double.parseDouble(args[0]);
      Double prevNumber=0d;
      Double precision=10d;
      char function;
      if (args.length>1){
        precision = Double.parseDouble(args[1]);
      }
      precision= Math.pow(10d,precision);
      if (args.length>2){function=args[2].toUpperCase().charAt(0);}
      else{function='C';}
      do {
        prevNumber=Math.round(number*precision)/precision;
        switch(function){
        case 'C':  number= Math.cos(number);
                    break;
        case 'P':  number=number-Math.tan(number);
                    break;
        case 'G':   number=1+(1/number);
                    break;
        case 'L':   number=(4*number)*(1-number);
                    break;
        }
        System.out.println(number);
      } while (Math.round(number*precision)/precision!=prevNumber);
      number=Math.round(number*precision)/precision;
      System.out.println(number);
    }
  }
}
