import java.util.Scanner;
import java.util.Arrays;

public class emailValid {
    static Scanner sc = new Scanner(System.in);
    static String mail = "";
    static boolean start = false;
    static String[] emails = {"alex@gmail.com","bob@gmail.com"};

    public static void check(String email){
        boolean contains = Arrays.stream(emails).anyMatch(email::equals);
        if (contains == true) {
            System.out.println("Email is in the list");
            start = false;
        } else 
            System.out.println("Email is not in the list");
            while (contains == false) {
                sc.nextLine();
            }
            
        }
    
    public static void restart() {
        System.out.println("Check another email? Y/N");
        char checkYes = sc.next().charAt(0);
        if (checkYes == 'Y' || checkYes == 'y') {
            start = true;
        } else 
            System.out.println("goodbye");
            System.exit(0);

    }
    
    public static void main(String[] args) {
        do {
            System.out.println("Enter an email address:");
            mail = sc.nextLine();
            check(mail);

            restart();

            
        } while (start == true);
        System.out.println("Hello, World!");
    }
}
