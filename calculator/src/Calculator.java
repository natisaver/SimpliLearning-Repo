import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double num1, num2; //same type can write multiple times
        double answer = 0.0;
        char operator;
        boolean status = false;
        
        do{
            System.out.println("Enter First Number: ");
            
            System.out.println("Enter Second Number: ");
            /*nextLine() is for strings, each primitive type got a method, 
            double in this case uses nextDouble()
            */
            if(sc.hasNextDouble()){
                num1 = sc.nextDouble(); //storing the input into num1

                System.out.println("ur val is");
                status = true;
            } else{
                System.out.println("not valid number");
                status = false;
            }

    } while (status = false);

    System.out.println("What Operation? ");
    operator = sc.next().charAt(0);

    //switch statement for cases
    switch (operator) {
        case '+': answer = num1 + num2;
            break;
        case '-': answer = num1 - num2;
            break;
        case '*': answer = num1 * num2;
            break;
        case '/': answer = num1 / num2;
            break;
        default:
            System.out.println("Invalid Number");
            break;
    }
    System.out.println(num1+" "+num2+" = "+answer);

    
}
}
