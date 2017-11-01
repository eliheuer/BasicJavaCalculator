/**
* A basic calculator program.
*
* The calculator can operate in two modes: Standard and Scientific modes.
* The Standard mode will allow the user to perform the following operations:
* add, subtract, multiply, and divide. The Scientific mode will allow the
* user to perform the same functionality as the Standard plus the following:
* sin x, cos x, tan x.
*
* @author  Eli Heuer
* @version 2.0
* @since   2017-10-31
*/

package calculator;

import java.util.Arrays;
import java.util.Scanner;

/** A basic calculator program. */
public class BasicCalculator2 {
    // Initialize modes and input
    static String mode = null;
    static String operatorMode = null; 
    static Scanner input = new Scanner(System.in);
    /** Invokes other methods and closes input */
    public static void main(String[] args) {
        welcome();
        calculate();
        input.close();
    }
    /** Select the mode */
    public static String modeSelector() {
        message(" ");
        message("Chose a calculator mode:");
        message("    (1) Standard");
        message("    (2) Scientific");
        message("    (3) MultipleOperations");
        message(" ");
        prompt("Enter mode: ");
        String inputMode = input.nextLine();
        if (inputMode.equals("1")||
            inputMode.equals("standard")||
            inputMode.equals("Standard")){
                mode = "standard";
                return mode;
        } else if (
            inputMode.equals("2")||
            inputMode.equals("scientific")||
            inputMode.equals("Scientific")){
                mode = "scientific";
                return mode;
        } else if (
            inputMode.equals("3")||
            inputMode.equals("multipleoperations")||
            inputMode.equals("MultipleOperations")){
                mode = "multiop";
                return mode;
        } else {
            message("Error: invalid selection for mode");
        }
        return mode;
    }

    /** calculate all the input */
    private static void calculate() {
        mode = modeSelector();
        message(" ");
        if (mode.equals("standard")) {
            operatorMode = standardMode();
        } else if (mode.equals("scientific")) {
            operatorMode = scientificMode();
        } else if (mode.equals("multiop")) {
            multiOpMode();
        } else {
            message("Error: Mode error, please reset mode");
        }
        if (operatorMode.equals("+")||
            operatorMode.equals("addition")||
            operatorMode.equals("Addition")){
                additionOperation();
        } else if (
            operatorMode.equals("-")||
            operatorMode.equals("subtraction")||
            operatorMode.equals("Subtraction")){
                subtractionOperation();
        } else if (
            operatorMode.equals("*")||
            operatorMode.equals("multiplication")||
            operatorMode.equals("Multiplication")){
                multiplicationOperation();
        } else if (
            operatorMode.equals("/")||
            operatorMode.equals("division")||
            operatorMode.equals("Division")){
                divisionOperation();
        } else if (
            operatorMode.equals("s")||
            operatorMode.equals("sin")||
            operatorMode.equals("Sin")){
                sinOperation();
        } else if (
            operatorMode.equals("c")||
            operatorMode.equals("cos")||
            operatorMode.equals("Cos")){
                cosOperation();
        } else if (
            operatorMode.equals("t")||
            operatorMode.equals("tan")||
            operatorMode.equals("Tan")){
                tanOperation();
        } else {
            message("Error: invalid selection for operation mode");
            calculate();
        }
    }

    /** Standard Mode */
    public static String standardMode() {
        message("Choose an operation to execute: ");
        message("    (+) Addition");
        message("    (-) Subtraction");
        message("    (*) Multiplication");
        message("    (/) Division");
        message(" ");
        prompt("Enter operation mode: ");
        String inputOperator = input.nextLine();
        return inputOperator;
    }
    /** Scientific Mode */
    public static String scientificMode() {
        message("Choose an operation to execute: ");
        message("    (+) Addition");
        message("    (-) Subtraction");
        message("    (*) Multiplication");
        message("    (/) Division");
        message("    (s) Sin");
        message("    (c) Cos");
        message("    (t) Tan");
        message(" ");
        prompt("Enter operation mode: ");
        String inputOperator = input.nextLine();
        return inputOperator;
    }

    /** Multiple operations Mode */
    public static void multiOpMode() {
        message("Welcome to Multiple operations Mode! ");
        message("A new feature in Basic Calculator 2. ");
        message("How many numbers do you want to work with? ");
        prompt("> ");
        double inputNumberArray = input.nextDouble();
        message("Enter " + (int)inputNumberArray + " numbers:");
        message(" ");
        double[] numberArray = new double[(int) inputNumberArray];
        // Input number array
        String[] opArray = new String[numberArray.length - 1];
        for(int i=0; i < numberArray.length; i++) {
            prompt("Enter a number: ");
            double numberInput = input.nextDouble();
            numberArray[i] = numberInput;
            input.nextLine();
            if (i < numberArray.length - 1) {
                prompt("Enter an operation( + - * / ): ");
                String opInput = input.nextLine();
                opArray[i] = opInput;
            } else {
                message(" ");
            }
        }
        System.out.println("New Array1: " + Arrays.toString(numberArray));
        System.out.println("New Array2: " + Arrays.toString(opArray));
        // Compute number array
        double sum = 0.0;
        double number = 0.0;
        int opCount = 0;
        for(int i=0; i < numberArray.length+1; i++) {
            message("at the start of loop "+i+" sum is "+sum); // debug
            if (i == 0) {
                number = numberArray[i];
                sum = number;
            } else if (opCount < opArray.length){
                if (opArray[i].equals("+")) {
                    sum = sum + number;
                }
                if (opArray[i].equals("-")) {
                    sum = sum - number;
                }
                if (opArray[i].equals("*")) {
                    sum = sum * number;
                }
                if (opArray[i].equals("/")) {
                    sum = sum / number;
                }
                opCount++;
            } else {
                // Done
                message(" ");
            }
            message("at the end of loop "+i+" sum is "+sum); // debug
        }
        // Output answer and ask to try again
        message(" ");
        message("Output = " + sum);
        message(" ");
        tryAgain();
    }
    /** Get array from input, divide all indexes. */
    private static void divisionOperation() {
        // Input number array length
        prompt("How many numbers do you want to divide: ");
        double inputNumberArray = input.nextDouble();
        message("Enter " + (int)inputNumberArray + " numbers:");
        double[] numberArray = new double[(int) inputNumberArray];
        // Input number array
        for(int i=0; i < numberArray.length; i++) {
            prompt("> ");
            double numberInput = input.nextDouble();
            numberArray[i] = numberInput;
        }
        // Compute number array
        double sum = 0.0;
        double number = 0.0;
        for(int i=0; i < numberArray.length; i++) {
            if (i == 0) {
                number = numberArray[i];
                sum = number;
            } else {
                number = numberArray[i];
                sum = sum / number;
            }
        }
        // Output answer and ask to try again
        message(" ");
        message("Output = " + sum);
        message(" ");
        tryAgain();
    }
    /** Get array from input, multiply all indexes. */
    private static void multiplicationOperation() {
        // Input number array length
        prompt("How many numbers do you want to multiply: ");
        double inputNumberArray = input.nextDouble();
        message("Enter " + (int)inputNumberArray + " numbers:");
        double[] numberArray = new double[(int) inputNumberArray];
        // Input number array
        for(int i=0; i < numberArray.length; i++) {
            prompt("> ");
            double numberInput = input.nextDouble();
            numberArray[i] = numberInput;
        }
        // Compute number array
        double sum = 0.0;
        double number = 0.0;
        for(int i=0; i < numberArray.length; i++) {
            if (i == 0) {
                number = numberArray[i];
                sum = number;
            } else {
                number = numberArray[i];
                sum = sum * number;
            }
        }
        // Output answer and ask to try again
        message(" ");
        message("Output = " + sum);
        message(" ");
        tryAgain();
    }
    /** Get array from input, subtract all indexes. */
    private static void subtractionOperation() {
        prompt("How many numbers do you want to subtract: ");
        double inputNumberArray = input.nextDouble();
        message("Enter " + (int)inputNumberArray + " numbers:");
        double[] numberArray = new double[(int) inputNumberArray];

        for(int i=0; i < numberArray.length; i++) {
            prompt("> ");
            double numberInput = input.nextDouble();
            numberArray[i] = numberInput;
        }
        double result = 0;
        for(int i=0; i < numberArray.length; i++) {
            result -= numberArray[i];
        }
        message("Output = " + result);
        message(" ");
        tryAgain();
    }
    /** Get array from input, add all indexes. */
    private static void additionOperation() {
        prompt("How many numbers do you want to add: ");
        double inputNumberArray = input.nextDouble();
        message("Enter " + (int)inputNumberArray + " numbers:");
        double[] numberArray = new double[(int) inputNumberArray];

        for(int i=0; i < numberArray.length; i++) {
            prompt("> ");
            double numberInput = input.nextDouble();
            numberArray[i] = numberInput;
        }
        double result = 0;
        for(int i=0; i < numberArray.length; i++) {
            result += numberArray[i];
        }
        message("Output = " + result);
        message(" ");
        tryAgain();
    }
    /** Computer sine from input. */
    private static void sinOperation() {
        prompt("Enter a number to find the sine: ");
        double inputX = input.nextDouble();
        double outputX = Math.sin(Math.toRadians(inputX));
        message("The sine of " + inputX + " degrees is: " + outputX);
        message(" ");
        tryAgain();
    }
    /** Computer cosine from input. */
    private static void cosOperation() {
        prompt("Enter a number to find the cosine: ");
        double inputX = input.nextDouble();
        double outputX = Math.cos(Math.toRadians(inputX));
        message("The sine of " + inputX + " degrees is: " + outputX);
        message(" ");
        tryAgain();
    }
    /** Computer tangent from input. */
    private static void tanOperation() {
        prompt("Enter a number to find the tangent: ");
        double inputX = input.nextDouble();
        double outputX = Math.tan(Math.toRadians(inputX));
        message("The tangent of " + inputX + " degrees is: " + outputX);
        message(" ");
        tryAgain();
  }
    /** Asks user to try again or quit. */
    public static void tryAgain() {
        input.nextLine();
        prompt("Try Again? (y/n) ");
        String tryAgain = input.nextLine();
        if (tryAgain.equals("y")||
            tryAgain.equals("Y")||
            tryAgain.equals("Yes")||
            tryAgain.equals("yes")){
                calculate();
        } else if (
            tryAgain.equals("n")||
            tryAgain.equals("N")||
            tryAgain.equals("No")||
            tryAgain.equals("no")){
                goodbye();
        } else {
            message("Error: ");
            goodbye();
        }
    }
    /** Welcome statement. */
    public static void welcome() {
        message("Welcome to BasicCalculator2.");
    }
    /** Goodbye statement. */
    public static void goodbye() {
        message(" ");
        message("Goodbye.");
    }
    /** Method used for shortening the prompt statement. */
    public static void prompt(String p) {
        System.out.print(p);
    }
    /** Method used for shortening the println statement. */
    public static void message(String m) {
        System.out.println(m);
    }
}
