package com.djbrodeur.sortingAlgorithms;

import com.djbrodeur.classes.Column;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BubbleSort implements SortingAlgorithm {

    private String name;

    public BubbleSort(){
        this.name = "Bubble Sort Algorithm";
    }

    public String getName() {
        return this.name;
    }
    public void runAlgorithm(Column[] valueArray){
        waitOneSecond();
        Arrays.sort(valueArray);
        waitOneSecond();
    }

    private void waitOneSecond() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e){
            // Pass
        }
    }

    public void showGraphic(Column[] valueArray) {
        String graphic = graphicStringBuilder(valueArray);
        System.out.println(graphic);
    }

    private String graphicStringBuilder(Column[] valueArray) {
        String stringBuilt = "| ";
        for(Column c : valueArray){
            stringBuilt += c.getValue();
            stringBuilt += " | ";
        }
        return stringBuilt;
    }
}
