

	import java.util.Stack;

public class ACalculator {
	

	    private final static Stack<String> stackForOperands = new Stack<String>();
	    private final static Stack<String> stackForOperators = new Stack<String>();


	    public static double evaluate(String expression) {
	        String[] tokens = expression.split(" "); //split line into tokes seperated by spaces
	        for (String token : tokens) {
	            String[] factorialTest = token.split(""); //for each test if its a lone number or a factorial

	            if(token.equals(")")) { //Test for a parenthases
	                while (!stackForOperators.isEmpty() && !stackForOperators.lastElement().equals("("))
	                    oneOperatorProcess(); //if we find a parentheses we should solve for the value immediately and then add that resolved value to the stack
	                stackForOperators.pop(); //after stopping with the last value in the operator stack being ( we can pop it since we no longer need it as a reference

	            }
	            else if(factorialTest.length == 2 && factorialTest[0].matches("-?\\d+(\\.\\d+)?") && factorialTest[1] .equals("!")) {
	                int factorialValue = factorial(Integer.parseInt(factorialTest[0]));
	                stackForOperands.push(Integer.toString(factorialValue)); //Solve for factorial value then push the result
	            }
	            else if (token.matches("-?\\d+(\\.\\d+)?")) {
	                stackForOperands.push(token); //push regular numbers to the stack
	            } else {
	                if ("+".equals(token) || "-".equals(token) || "!".equals(token) || "^".equals(token) || "*".equals(token) || "/".equals(token)
	                        || ">".equals(token) || ">=".equals(token) || "<".equals(token) || "<=".equals(token) || "==".equals(token) || "!=".equals(token)
	                        || ")".equals(token) || "(".equals(token)) {
	                    stackForOperators.push(token); //Search for proper operators and push them to the stack
	                }
	            }
	        }
	        while (!stackForOperators.isEmpty())
	            oneOperatorProcess(); //Handle operations until we run out of operators
	        return Double.parseDouble(stackForOperands.pop()); //Return the final value in the operand stack
	    }

	    private static void oneOperatorProcess() {
	        double a;
	        double b;
	        String operator = stackForOperators.pop();
	        String bString = stackForOperands.pop();
	        String aString = stackForOperands.pop();

	            a = Double.parseDouble(aString);
	            b = Double.parseDouble(bString);

	            //Parse the values accordingly

	        double result = 0;

	        switch (operator) { //search for the appropriate oeprand and do the math
	            case "+":
	                result = a + b;
	                break;
	            case "-":
	                result = a - b;
	                break;
	            case "^":
	                result = Math.pow(a,b);
	                break;
	            case "*":
	                result = a*b;
	                break;
	            case "/":
	                result = a/b;
	                break;
	            case ">":
	                result = (a > b ? 1 : 0);
	                break;
	            case ">=":
	                result = (a >= b ? 1 : 0);
	                break;
	            case "<":
	                result = (a < b ? 1 : 0);
	                break;
	            case "<=":
	                result = (a <= b ? 1 : 0);
	                break;
	            case "==":
	                result = (a == b ? 1 : 0);
	                break;
	            case "!=":
	                result = (a != b ? 1 : 0);
	                break;


	        }
	        stackForOperands.push(Double.toString(result)); //push result to operand stack
	    }

	    private static int factorial( int iNo ) { //handle factorial calculations recursively

	        // Make sure that the input argument is positive

	        if (iNo < 0) throw
	                new IllegalArgumentException("iNo must be >= 0");

	        // Use simple look to compute factorial....

	        int factorial = 1;
	        for(int i = 2; i <= iNo; i++)
	            factorial *= i;

	        return factorial;
	    }


	}

