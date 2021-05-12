package com.djbrodeur.classes;

import com.djbrodeur.sortingAlgorithms.*;

import java.util.*;

public class MainMenu {

    public int MAX_OPTIONS;
    public SortingAlgorithm[] algorithms;

    public MainMenu() {
        algorithms = generateAlgorithmMenu();
        MAX_OPTIONS = algorithms.length;
    }

    private SortingAlgorithm[] generateAlgorithmMenu() {
        List<SortingAlgorithm> algorithmList = new ArrayList<SortingAlgorithm>();

        algorithmList.add(new BubbleSort());
        algorithmList.add(new Quicksort());
        algorithmList.add(new MergeSort());
        algorithmList.add(new InsertionSort());

        SortingAlgorithm[] algorithmArray = new SortingAlgorithm[algorithmList.size()];
        algorithmArray = algorithmList.toArray(algorithmArray);
        return algorithmArray;
    }

    public void showMenu(){
        System.out.println("MAIN MENU");
        for(int i = 0; i < MAX_OPTIONS; i++){
            System.out.println(i + "- " + algorithms[i].getName());
        }
        System.out.println(MAX_OPTIONS + "- Exit");
    }

    public void processUserChoiceFromMenu(int choice){
        if(choice == MAX_OPTIONS){
            Utilities.clearScreen();
            System.out.println("Thank you for using this. Now exiting.");
            Utilities.waitOneSecond();
            System.exit(0);
        } else if (choice < 0 || choice > MAX_OPTIONS){
            System.out.println("Invalid entry.");
        } else {
            AlgorithmController controller = new AlgorithmController();
            controller.runAlgorithm(algorithms[choice]);
        }
    }
}
