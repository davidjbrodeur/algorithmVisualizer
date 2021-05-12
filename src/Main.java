import com.djbrodeur.classes.MainMenu;
import com.djbrodeur.classes.Utilities;

/*
TODO:
 - Implement tree sort & selection sort.
 - Create a visualization for the algorithm.
 */

public class Main {

    public static void main(String [] args) {
        int userInput = -1;
        MainMenu menu = new MainMenu();
        while(userInput != menu.MAX_OPTIONS){
            menu.showMenu();
            userInput = Utilities.registerUserInput(menu);
            menu.processUserChoiceFromMenu(userInput);
            Utilities.clearScreen();
        }
    }

}

