package com.djbrodeur.classes;

import com.djbrodeur.sortingAlgorithms.BubbleSort;

public class MainMenu {

    public int MAX_OPTIONS = 2;

    public void showMenu(){
        System.out.println("MAIN MENU");
        System.out.println("1- Bubble sort");
        System.out.println("2- Exit");
    }

    public void processUserChoiceFromMenu(int choice){
        if(choice == 1){
            AlgorithmController controller = new AlgorithmController();
            controller.runAlgorithm(new BubbleSort());
        } else if (choice == 2) {
            System.exit(0);
        } else {
            System.out.println("Wrong choice");
        }
    }

}
