package dev.yawkar.plan;

import dev.yawkar.algorithm.SearchAlgorithm;
import dev.yawkar.matrix.MatrixGenerator;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public abstract class AbstractPlan {

    @Param({"100_000", "10_000", "1000", "100", "10"})
    public int rowsNumber;
    @Param({"10", "100", "1000", "10_000", "100_000"})
    public int columnsNumber;

    public long[][] matrix;

    public SearchAlgorithm algorithm;

    public MatrixGenerator generator;

    public void setUp() {
        matrix = generator.generate(rowsNumber, columnsNumber);
    };
}
