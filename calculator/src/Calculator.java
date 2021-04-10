import java.util.Scanner;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class Calculator {
    static Scanner sc = new Scanner(System.in);
    static double num1, num2; // same type can write multiple times
    static double answer = 0.0;
    static char operator;
    static boolean valid = false; // used to continue while loop, if num return error
    static boolean start = false;

    public static void main(String[] args) {

        do {
            startcal();

            System.out.println("What Operator (+, -, *, /): ");

            operator = sc.next().charAt(0);

            // switch statement for cases
            switch (operator) {
            case '+':
                answer = num1 + num2;
                break;
            case '-':
                answer = num1 - num2;
                break;
            case '*':
                answer = num1 * num2;
                break;
            case '/':
                answer = num1 / num2;
                break;
            default:
                System.out.println("Invalid Operator");
                break;
            }

            System.out.println(num1 + " " + num2 + " = " + answer);
            start = false;
            System.out.println("you want use again? Type Y to continue");
            char yes = sc.next().charAt(0);
            if (yes == 'y' || yes == 'Y') {
                start = true;
            } else
                System.out.println("k bye.");

        } while (start == true);

    }

    // startcal

    static void startcal() {
        System.out.println("Enter First Number");
        while (!sc.hasNextDouble()) {
            System.out.println("Please key a valid number");
            sc.next();
        }
        num1 = sc.nextDouble();
        /*
         * nextLine() is for strings, each primitive type got a method, double in this
         * case uses nextDouble()
         */
        System.out.println("Enter second number:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please key a valid number");
            sc.next();
        }
        num2 = sc.nextDouble();
    }

}
