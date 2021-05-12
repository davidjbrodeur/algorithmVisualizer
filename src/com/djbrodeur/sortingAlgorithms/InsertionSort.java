package com.djbrodeur.sortingAlgorithms;

import com.djbrodeur.classes.Column;
import com.djbrodeur.classes.Utilities;

public class InsertionSort implements SortingAlgorithm {

    private String name;
    private int numberOfIterations;

    public InsertionSort(){
        this.name = "Insertion Sort Algorithm";
        numberOfIterations = 0;
    }

    public String getName() {
        return this.name;
    }

    public int runAlgorithm(Column[] valueArray){
        Utilities.waitOneSecond();
        sort(valueArray);
        return this.numberOfIterations;
    }

    private void sort(Column[] valueArray) {
        int n = valueArray.length;
        for (int i = 1; i < n; ++i) {
            Column key = valueArray[i];
            int j = i - 1;
            while (j >= 0 && valueArray[j].isGreaterThan(key)) {
                valueArray[j + 1] = valueArray[j];
                j = j - 1;
                this.numberOfIterations++;
            }
            valueArray[j + 1] = key;
            Utilities.showGraphic(valueArray);
            Utilities.waitHalfSecond();
        }
    }
}
