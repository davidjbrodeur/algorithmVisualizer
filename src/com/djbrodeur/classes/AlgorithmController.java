package com.djbrodeur.classes;

import com.djbrodeur.sortingAlgorithms.SortingAlgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlgorithmController {

    private Column[] valueArray;
    private final int MAX_NUMBER_OF_VALUE = 15;

    public void runAlgorithm(SortingAlgorithm algorithm) {
        System.out.println("This is the unsorted (initial) array of value:");
        Utilities.showGraphic(valueArray);
        int numberOfIterations = algorithm.runAlgorithm(valueArray);
        System.out.println("This is the sorted (final) array of value:");
        Utilities.showGraphic(valueArray);
        System.out.println("It took " + numberOfIterations + " manipulations to complete the sort");
    }

    public AlgorithmController(){
        valueArray = generateValueArray();
    }

    private Column[] generateValueArray() {
        Column[] row = new Column[MAX_NUMBER_OF_VALUE];
        for(int i = 0; i < MAX_NUMBER_OF_VALUE; i++){
            row[i] = new Column(i + 1);
        }
        row = shuffleArrayOfValue(row);
        return row;
    }

    private Column[] shuffleArrayOfValue(Column[] arrayToBeShuffled) {
        List<Column> intList = Arrays.asList(arrayToBeShuffled);
        Collections.shuffle(intList);
        intList.toArray(arrayToBeShuffled);
        return arrayToBeShuffled;
    }
}
