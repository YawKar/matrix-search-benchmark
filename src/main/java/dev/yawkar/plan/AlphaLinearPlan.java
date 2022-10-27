package dev.yawkar.plan;

import dev.yawkar.matrix.MatrixGenerator;
import dev.yawkar.matrix.generator.AlphaGenerator;
import dev.yawkar.plan.simple.SimpleLinearPlan;
import org.openjdk.jmh.annotations.Setup;

public class AlphaLinearPlan extends SimpleLinearPlan {

    public MatrixGenerator generator = new AlphaGenerator();

    @Setup
    public void setUp() {
        matrix = generator.generate(rowsNumber, columnsNumber);
    }
}
