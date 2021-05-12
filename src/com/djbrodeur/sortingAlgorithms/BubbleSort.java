package com.djbrodeur.sortingAlgorithms;

import com.djbrodeur.classes.Column;
import com.djbrodeur.classes.Utilities;

public class BubbleSort implements SortingAlgorithm {

    private String name;
    int numberOfIterations;

    public BubbleSort(){
        numberOfIterations = 0;
        this.name = "Bubble Sort Algorithm";
    }

    public String getName() {
        return this.name;
    }

    public int runAlgorithm(Column[] valueArray){
        Utilities.waitOneSecond();
        sort(valueArray);
        return numberOfIterations;
    }

    private void sort(Column[] valueArray) {
        int numberOfElement = valueArray.length;
        Column temp;
        for(int i = 0; i < numberOfElement; i++){
            for(int j = 1; j < numberOfElement; j++){
                if(valueArray[j - 1].isGreaterThan(valueArray[j])){
                    Utilities.swapElementOfArray(valueArray, j-1, j);
                    Utilities.waitHalfSecond();
                    Utilities.showGraphic(valueArray);
                }
                this.numberOfIterations++;
            }
        }
    }
}