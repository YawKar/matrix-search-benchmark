package dev.yawkar.plan;

import dev.yawkar.matrix.MatrixGenerator;
import dev.yawkar.matrix.generator.BetaGenerator;
import dev.yawkar.plan.simple.SimpleLinearPlan;
import org.openjdk.jmh.annotations.Setup;

public class BetaLinearPlan extends SimpleLinearPlan {

    public MatrixGenerator generator = new BetaGenerator();

    @Setup
    public void setUp() {
        matrix = generator.generate(rowsNumber, columnsNumber);
    }
}
