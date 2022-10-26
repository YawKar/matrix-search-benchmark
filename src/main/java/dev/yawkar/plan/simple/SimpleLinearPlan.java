package dev.yawkar.plan.simple;

import dev.yawkar.algorithm.SearchAlgorithm;
import dev.yawkar.algorithm.impl.LinearSearch;

public class SimpleLinearPlan extends SimplePlan {

    public SearchAlgorithm algorithm = new LinearSearch();
}
