/**
 *  Etude 3, Arithmetic.
 *
 * @aurthor Nick Sparrow (4742998).
 */
import java.util.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import java.math.*;

public class Arithmetic {
  
    private static String direction;
    private static BigInteger target;
    private static BigInteger [] numbers;
    private static String equation = "";
    
    /**
     *  Operations uses recurtion to build up all the possible combinations 
     *  of the operators.
     *
     * @param op is a string representation of the operators. 
     */
    public static void operations(String op) {
        if (equation != "") return;
        else if (op.length() == numbers.length - 1) {
            calculate(op);
        } else if (op.length() == numbers.length) {
            return;
        }      
        operations(op + "+");
        operations(op + "*");
        return;
    }

    /**
     *  Calculate takes a string of operators and calculates the result of
     *  putting them into the array of numbers and if it equals the target
     *  result then it sets the equation data feild with the full eqaution
     *  that sums to the target value.
     *
     * @param operations is a string of +'s/*'s.
     */
    public static void calculate(String operations) {
        String resultStr = "";
        BigInteger result = null;
        for (int i = 0; i < operations.length(); i++) {
            resultStr += (operations.charAt(i) == '+') ? (numbers[i] + "+") : (numbers[i] + "*");            
        }
        resultStr += numbers[numbers.length - 1];
        if (direction.equals("L")) {
            result = numbers[0];
            for (int i = 0; i < operations.length(); i++) {
                result = (operations.charAt(i) == '+') ? (result.add(numbers[i+1])) : (result.multiply(numbers[i+1]));
            }
        } else {
            try {
                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByName("JavaScript");
                Object t = engine.eval(resultStr);
                result = new BigInteger(new BigDecimal(t.toString()).toPlainString());                
            } catch (Exception e) {    }
        }
        if ((target.equals(result)) && (equation == "")) {
            equation = resultStr;
        }
    }
  
    public static void main (String [] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            equation = "";
            String input = scan.nextLine();
            String [] numsIn = input.split(" +");
            input = scan.nextLine();
            String [] tarAndDir = input.split(" +");
            target = new BigInteger(tarAndDir[0]);
            direction = (tarAndDir.length > 1) ? (direction = tarAndDir[1]) : (direction = "N");
            numbers = new BigInteger[numsIn.length];
            for (int i = 0; i < numsIn.length; i++) {
                numbers[i] = new BigInteger(numsIn[i]);
            }
            operations("");
            if (equation != "") {
                System.out.println(direction + " " + equation);
            } else {
                System.out.println(direction + " Impossible");
            }
        }
    }
}
