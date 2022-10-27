package dev.yawkar.plan;

import dev.yawkar.matrix.MatrixGenerator;
import dev.yawkar.matrix.generator.AlphaGenerator;
import dev.yawkar.plan.simple.SimpleExpBinaryPlan;
import org.openjdk.jmh.annotations.Setup;

public class AlphaExpBinaryPlan extends SimpleExpBinaryPlan {

    public MatrixGenerator generator = new AlphaGenerator();

    @Setup
    public void setUp() {
        matrix = generator.generate(rowsNumber, columnsNumber);
    }
}
