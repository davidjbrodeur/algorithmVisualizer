import com.djbrodeur.classes.MainMenu;

import java.util.Scanner;

/*
TODO:
 - Create a List of algorithms for the menu options to pass them to the controller and make sure that whenever you add a new algorithm it adds a new menu options
 - Actually make the Bubble Sort
 - Create a visualization for the algorithm
 - Implement other algorithms
 */

public class Main {

    public static void main(String [] args) {
        int userInput = -1;
        MainMenu menu = new MainMenu();
        while(userInput != menu.MAX_OPTIONS){
            menu.showMenu();
            userInput = registerUserInput(menu);
            menu.processUserChoiceFromMenu(userInput);
            clearScreen();
        }
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static int registerUserInput(MainMenu menu) {
        Scanner myObj = new Scanner(System.in);
        boolean choiceIsValid = false;
        int userInput = -1;

        while(!choiceIsValid){
            System.out.println("Enter a choice");
            try {
                String strInput = myObj.next();
                if(checkInput(strInput, menu)){
                    userInput = convertTheInput(strInput);
                    choiceIsValid = true;
                } else {
                    System.out.println("Invalid answer. Try again.");
                }
            } catch (Exception e){
                System.out.println(e);
            }
        }
        return userInput;
    }

    private static int convertTheInput(String strInput) {
        char charInput = strInput.charAt(0);
        int userInput = Character.getNumericValue(charInput);
        return userInput;
    }

    private static boolean checkInput(String strInput, MainMenu menu) {
        if(!checkLength(strInput)) return false;
        if(!checkContent(strInput, menu)) return false;
        return true;
    }

    private static boolean checkContent(String strInput, MainMenu menu) {
        char charInput = strInput.charAt(0);
        int userInput = Character.getNumericValue(charInput);
        if(userInput > menu.MAX_OPTIONS){
            return false;
        } else {
            return true;
        }
    }

    private static boolean checkLength(String strInput) {
        if(strInput.length() != 1) return false;
        return true;
    }

}

