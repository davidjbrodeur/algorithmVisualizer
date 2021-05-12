package com.djbrodeur.sortingAlgorithms;

import com.djbrodeur.classes.Column;
import com.djbrodeur.classes.Utilities;

public class MergeSort implements SortingAlgorithm {

    private String name;
    private int numberOfIterations;

    public MergeSort(){
        this.name = "Merge Sort Algorithm";
        numberOfIterations = 0;
    }

    public String getName() {
        return this.name;
    }

    public int runAlgorithm(Column[] valueArray){
        Utilities.waitOneSecond();
        sort(valueArray, 0, valueArray.length - 1);
        return this.numberOfIterations;
    }

    void sort(Column[] valueArray, int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first half
            sort(valueArray, l, m);
            Utilities.showGraphic(valueArray);
            Utilities.waitHalfSecond();
            this.numberOfIterations++;

            // Sort second half
            sort(valueArray, m + 1, r);
            Utilities.showGraphic(valueArray);
            Utilities.waitHalfSecond();
            this.numberOfIterations++;

            // Merge the sorted halves
            merge(valueArray, l, m, r);
            Utilities.showGraphic(valueArray);
            Utilities.waitHalfSecond();
            this.numberOfIterations++;
        }
    }

    void merge(Column[] valueArray, int left, int middle, int right)
    {

        int n1 = middle - left + 1;
        int n2 = right - middle;

        Column temporaryLeftArray[] = new Column[n1];
        Column temporaryRightArray[] = new Column[n2];

        for (int i = 0; i < n1; ++i){
            temporaryLeftArray[i] = valueArray[left + i];
        }

        for (int j = 0; j < n2; ++j){
            temporaryRightArray[j] = valueArray[middle + 1 + j];
        }

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (temporaryLeftArray[i].isLessThan(temporaryRightArray[j])) {
                valueArray[k] = temporaryLeftArray[i];
                i++;
            }
            else {
                valueArray[k] = temporaryRightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            valueArray[k] = temporaryLeftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            valueArray[k] = temporaryRightArray[j];
            j++;
            k++;
        }
    }
}
