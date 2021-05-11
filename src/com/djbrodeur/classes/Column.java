package com.djbrodeur.classes;

public class Column implements Comparable<Column> {

    private int value;

    public Column(int receivedValue) {
        value = receivedValue;
    }

    public int getValue() {
        return value;
    }

    public boolean isGreaterThan(Column toCompareTo){
        return this.compareTo(toCompareTo) > 0;
    }

    public boolean isLessThan(Column toCompareTo){
        return this.compareTo(toCompareTo) < 0;
    }

    @Override
    public int compareTo(Column compareColumn){
        int valueOfCompare = compareColumn.getValue();
        int ascendingOrderValueToCompare = this.value - valueOfCompare;
        return ascendingOrderValueToCompare;
    }

}
