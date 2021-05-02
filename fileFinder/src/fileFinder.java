import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
import java.util.InputMismatchException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// import static testclass.Reversed.reversed;

public class fileFinder {
    static Scanner sc = new Scanner(System.in);
    static boolean menustart = true;
    static boolean start = false;
    static String filename = "";
    static String filenametodelete = "";

    // File f = new File("C:/Users/natis/Pictures");
    static File f = new File(System.getProperty("user.dir") + "/images");

    // Populates the array with names of files and directories
    static String[] pathnames = f.list();
    

    //SELECTION OPTIONS (0)
    public static void display_menu() {
        System.out.println("\nFile Finder 2021, created by Nathaniel Chin");
        System.out.println ("1) View List of Files \n2) Delete a File\n3) Search a File (Case Sensitive)\n4) Exit");
        System.out.print ( "Input a number \nSelection: " );
    }

    //SHOW LIST OF FILES (1)
    public static void list_files() {

        // For-Each Loop for items in array
        for (String i : pathnames) {
            // Print the names of files and directories
            System.out.println(i);
        }

        System.out.println("\n*** Process Completed *** \n Enter '4' - Exit Program 🛑 \n Enter '5' - Return to Menu 🔙");

    }

    //delete function (2a) 
    public static void DeleteFile(String filenametodel) {
          File myObj = new File(System.getProperty("user.dir") + "/images" + "/" + filenametodel); 
          if (myObj.delete()) { 
            System.out.println("Deleted the file: " + myObj.getName());
          } else {
            System.out.println("Failed to delete the file. ⚠️");
        } 
    } 

    //initialise and restart the deleting process (2b)
    public static void startDelete(){
        do {
            System.out.println("Enter a file name (e.g naruto.png) to delete:");
            filenametodelete = sc.nextLine();
            start = false; 
            DeleteFile(filenametodelete);
            System.out.println("\nDelete another file? Y/N");
            char yes = sc.next().charAt(0);
            sc.nextLine(); //must put this to help absorb the line from sc.next(), check stackoverflow
            if (yes == 'Y' || yes == 'y') {
                start = true;
            } else 
                System.out.println("\n*** Process Completed *** \n Enter '4' - Exit Program 🛑 \n Enter '5' - Return to Menu 🔙");
                
    
        } while (start != false);    
    }

    //DELETE A FILE (2)
    public static void delete_files() {
        startDelete();
    }

    //Check if file exists function (3a)
    public static void check(String filenameinput){
        boolean contains = Arrays.stream(pathnames).anyMatch(filenameinput::equals);
        if (contains == true) {
            System.out.println("✅ File is in the directory");

        } else 
            System.out.println("❌ File is not in the directory");          
    }

    //Restart Search function and initialise 3a (3b)
    public static void startSearch(){
        do {
            System.out.println("Enter a file name (e.g naruto.png) to search:");
            filename = sc.nextLine();
            start = false; 
            check(filename);
            System.out.println("\nCheck another file? Y/N");
            char yes = sc.next().charAt(0);
            sc.nextLine(); //must put this to help absorb the line from sc.next(), check stackoverflow
            if (yes == 'Y' || yes == 'y') {
                start = true;
            } else 
                System.out.println("\n*** Process Completed *** \n Enter '4' - Exit Program 🛑 \n Enter '5' - Return to Menu 🔙");
                
    
        } while (start != false);    
    }

    //SEARCH THE FILE (3)
    public static void search_files() {
        startSearch();
    }

    //MENU SELECTOR MAIN 
    public static void menuselect() {
        Scanner in = new Scanner ( System.in );
        
        display_menu(); //to show options

        do {
            try {
                switch ( in.nextInt() ) {
                        case 1:
                            System.out.println ( "You picked option 1, heres the list:" );
                            list_files();
                            
                            break;

                        case 2:
                            System.out.println ( "You picked option 2, deleting..." );
                            delete_files();
                            break;

                        case 3:
                            System.out.println ( "You picked option 3, searching..." );
                            search_files();
                            break;

                        case 4:
                            menustart = false;
                            System.out.println ( "You picked option 4, exiting..." );
                            System.exit(0);
                            break;

                        case 5:
                            menuselect();
                            break;

                        default:
                            // System.err.println ( "Unrecognized option" );
                            System.out.println("*** Invalid input *** \n Please write a number from '1-4' \n *To view list of options again, input '5': ");
                            break;
                        } 

            }   catch (InputMismatchException e){ //this catches any strings inputted, cos my switch is in.nextInt()
                        System.out.println("*** Invalid input *** \n Please write a number from '1-4': ");
                        in.nextLine();
                        continue;
                    }


        } while(menustart);

        
      }

    public static void main(String[] args) throws Exception {
        menuselect();

    }
}
