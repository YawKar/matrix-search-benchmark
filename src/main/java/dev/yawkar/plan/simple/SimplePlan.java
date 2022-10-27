package dev.yawkar.plan.simple;

import dev.yawkar.algorithm.SearchAlgorithm;
import dev.yawkar.matrix.MatrixGenerator;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class SimplePlan {

    @Param({"2", "4", "8", "16", "32", "64", "128", "256", "512", "1024", "2048", "4096", "8192"})
    public int rowsNumber;

    public int columnsNumber = 8192;

    public SearchAlgorithm algorithm;

    public MatrixGenerator generator;

    public long[][] matrix;
}
