package dev.yawkar.matrix.generator;

import dev.yawkar.matrix.MatrixGenerator;

public class AlphaGenerator implements MatrixGenerator {

    @Override
    public long[][] generate(int rowsNumber, int columnsNumber) {
        long[][] matrix = new long[rowsNumber][columnsNumber];
        for (int i = 0; i < rowsNumber; ++i) {
            for (int j = 0; j < columnsNumber; ++j) {
                matrix[i][j] = ((long) columnsNumber / rowsNumber * i + j) * 2;
            }
        }
        return matrix;
    }
}
