import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
import java.util.InputMismatchException;

public class emailValid {
    static Scanner sc = new Scanner(System.in);
    static String mail = "";
    static boolean start = false;
    static boolean menustart = true;
    static String[] emails = {"alex@gmail.com","bob@gmail.com"};

    //OPTION 1 - THE VALIDATION PROCESS
    public static void check(String email){
        boolean contains = Arrays.stream(emails).anyMatch(email::equals);
        if (contains == true) {
            System.out.println("Email is in the list");

        } else 
            System.out.println("Email is not in the list");          
    }
    //OPTION 1 - GETTING THE INPUT AND RESTARTING PROCESS
    public static void startValid(){
        do {
            System.out.println("Enter an email address:");
            mail = sc.nextLine();
            start = false; 
            check(mail);
            System.out.println("Check another email? Y/N");
            char yes = sc.next().charAt(0);
            sc.nextLine(); //must put this to help absorb the line from sc.next(), check stackoverflow
            if (yes == 'Y' || yes == 'y') {
                start = true;
            } else 
                System.out.println("goodbye");
                
    
        } while (start != false);    
    }

    //OPTION 2 - VIEW LIST
    public static void viewList(){
        for(int i = 0; i < emails.length; i++) {
            System.out.println(i+1 + ". " + emails[i]);
        }
    }

    //SELECTION OPTIONS
    public static void display_menu() {
        System.out.println ( "1) Validate an email \n2) View Email List 2\n3) Exit" );
        System.out.print ( "Selection: " );
    }
      
    //MENU SELECTOR MAIN 
    public static void menuselect() {
        Scanner in = new Scanner ( System.in );
        
        display_menu(); //to show options

        do {
            try {
                switch ( in.nextInt() ) {
                        case 1:
                            menustart = false;
                            System.out.println ( "You picked option 1, validating..." );
                            startValid();

                            break;
                        case 2:
                            menustart = false;
                            System.out.println ( "You picked option 2, heres the list:" );
                            viewList();
                            break;
                        case 3:
                            menustart = false;
                            System.out.println ( "You picked option 3, exiting..." );
                            System.exit(0);
                            break;
                        default:
                            // System.err.println ( "Unrecognized option" );
                            System.out.println("Invalid input \n Please write a number from '1-3': ");
                            break;
                        } 
            }   catch (InputMismatchException e){
                        System.out.println("Invalid input \n Please write a number from '1-3': ");
                        in.nextLine();
                        continue;
                    }


        } while(menustart);

        
      }

    public static void main(String[] args) {
        menuselect();
    }
}
