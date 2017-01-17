public class CreateHelperFunction {
    
    public static double evaluate(String eq) {
        double res = 0.0;        
        String MinusToPlus = eq.replace("-", "+-");
        String[] splitAddition = MinusToPlus.split("\\+");
	
        for (String multipl : splitAddition) {
            String[] splitMultiplication = multipl.split("\\*");
            double multRes = 1.0;
            for (String operand : splitMultiplication) {
                if (operand.contains("/")) {
                    String[] splitDivision = operand.split("\\/");
                    double dividend = Double.parseDouble(splitDivision[0]);
                    for (int i = 1; i < splitDivision.length; i++) {
                        dividend /= Double.parseDouble(splitDivision[i]);
                    }
                    multRes *= dividend;
                } else {
                    multRes *= Double.parseDouble(operand);
                }
            }
            res += multRes;
        }
	
        return res;
    } 
    
    
    
    
    public static void main(String[] args) {
        String eq = "1*-5+4*8+9*2";
        double res = evaluate(eq);
        System.out.println(res);
    }
    
 
    
}
