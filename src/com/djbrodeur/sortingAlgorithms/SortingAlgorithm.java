package com.djbrodeur.sortingAlgorithms;

import com.djbrodeur.classes.Column;

public interface SortingAlgorithm {

    public String getName();
    public int runAlgorithm(Column[] valueArray);

}
