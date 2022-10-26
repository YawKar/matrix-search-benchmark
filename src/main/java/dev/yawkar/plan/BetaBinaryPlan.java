package dev.yawkar.plan;

import dev.yawkar.matrix.MatrixGenerator;
import dev.yawkar.matrix.generator.BetaGenerator;
import dev.yawkar.plan.simple.SimpleBinaryPlan;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class BetaBinaryPlan extends SimpleBinaryPlan {

    @Param({"2", "4", "8", "16", "32", "64", "128", "256", "512", "1024", "2048", "4096", "8192"})
    public int rowsNumber;

    public MatrixGenerator generator = new BetaGenerator();

    @Setup
    public void setUp() {
        matrix = generator.generate(rowsNumber, columnsNumber);
    }
}
