package dev.yawkar.algorithm.impl;

import dev.yawkar.algorithm.SearchAlgorithm;

public class BinaryOnRowLinearOnColumnSearch implements SearchAlgorithm {

    private int firstLowerOrEqualTo(long target, int left, int right, long[] row) {
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (row[middle] > target) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right - 1;
    }

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
                currentColumn = firstLowerOrEqualTo(target, -1, currentColumn, array[currentRow]);
            }
        }
        return false;
    }
}
