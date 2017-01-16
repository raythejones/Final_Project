public class CreateHelperFunction {

public static double evaluate(String eq) {
        double res = 0.0;
        String []divPlus = eq.split("\\+");
        for (String mult : divPlus) {
            String []divMult = mult.split("\\*");
            double multRes = 1.0;
            for (String operand : divMult) {
                multRes *= Integer.parseInt(operand);
            }
            res += multRes;
        }
        return res;
    }
    



    public static void main(String[] args) {
        String eq = "1*5+4*8+9*2";
        double res = evaluate(eq);
        System.out.println(res);
    }

 

}