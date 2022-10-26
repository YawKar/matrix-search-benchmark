package dev.yawkar.plan.sample;

import dev.yawkar.algorithm.SearchAlgorithm;
import dev.yawkar.algorithm.impl.LinearSearch;
import dev.yawkar.matrix.MatrixGenerator;
import dev.yawkar.matrix.generator.AlphaGenerator;
import dev.yawkar.plan.AbstractPlan;

public class AlphaLinearPlan extends AbstractPlan {

    public SearchAlgorithm algorithm = new LinearSearch();

    public MatrixGenerator generator = new AlphaGenerator();
}
