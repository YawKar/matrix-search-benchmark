package dev.yawkar.plan.simple;

import dev.yawkar.algorithm.SearchAlgorithm;
import dev.yawkar.matrix.MatrixGenerator;

public class SimplePlan {

    public int rowsNumber;

    public int columnsNumber = 8192;

    public SearchAlgorithm algorithm;

    public MatrixGenerator generator;

    public long[][] matrix;

    public void setUp() {
        matrix = generator.generate(rowsNumber, columnsNumber);
    }
}
