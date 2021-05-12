package com.djbrodeur.sortingAlgorithms;

import com.djbrodeur.classes.Column;
import com.djbrodeur.classes.Utilities;

public class Quicksort implements SortingAlgorithm {

    private String name;
    private int numberOfIterations;

    public Quicksort(){
        this.name = "Quicksort Algorithm";
        numberOfIterations = 0;
    }

    public String getName() {
        return this.name;
    }

    public int runAlgorithm(Column[] valueArray){
        Utilities.waitOneSecond();
        quickSort(valueArray, 0, valueArray.length - 1);
        return this.numberOfIterations;
    }

    private void quickSort(Column[] valueArray, int low, int high)
    {
        if (low < high)
        {
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(valueArray, low, high);
            // Separately sort elements before
            // partition and after partition
            quickSort(valueArray, low, pi - 1);
            quickSort(valueArray, pi + 1, high);
        }
    }

    private int partition(Column[] valueArray, int low, int high){
        Column pivot = valueArray[high];
        int i = (low - 1);
        for(int j = low; j <= high -1; j++){
            if(valueArray[j].isLessThan(pivot)){
                i++;
                Utilities.swapElementOfArray(valueArray, i, j);
                Utilities.showGraphic(valueArray);
                Utilities.waitHalfSecond();
            }
            this.numberOfIterations++;
        }
        Utilities.swapElementOfArray(valueArray, i + 1, high);
        return (i + 1);
    }
}
