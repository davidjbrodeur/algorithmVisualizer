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
        showGraphic();
        algorithm.runAlgorithm(valueArray);
        System.out.println("This is the sorted (final) array of value:");
        showGraphic();
    }

    public AlgorithmController(){
        valueArray = generateValueArray();
    }

    public void showGraphic() {
        String graphic = graphicStringBuilder();
        System.out.println(graphic);
    }

    private String graphicStringBuilder() {
        String stringBuilt = "| ";
        for(Column c : valueArray){
            stringBuilt += c.getValue();
            stringBuilt += " | ";
        }
        return stringBuilt;
    }

    private Column[] generateValueArray() {
        Column[] row = new Column[MAX_NUMBER_OF_VALUE];
        for(int i = 0; i < MAX_NUMBER_OF_VALUE; i++){
            row[i] = new Column(i + 1);
        }
        row = shuffle(row);
        return row;
    }

    private Column[] shuffle(Column[] arrayToBeShuffled) {
        List<Column> intList = Arrays.asList(arrayToBeShuffled);
        Collections.shuffle(intList);
        intList.toArray(arrayToBeShuffled);
        return arrayToBeShuffled;
    }
}
