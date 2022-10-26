package dev.yawkar.algorithm.impl;

import dev.yawkar.algorithm.SearchAlgorithm;

public class LinearSearch implements SearchAlgorithm {

    @Override
    public boolean search(long[][] array, long target) {
        int currentRow = 0;
        int currentColumn = array[0].length - 1;
        while (currentRow < array.length && currentColumn > -1) {
            if (array[currentRow][currentColumn] == target) {
                return true;
            } else if (array[currentRow][currentColumn] < target) {
                ++currentRow;
            } else {
                --currentColumn;
            }
        }
        return false;
    }
}
