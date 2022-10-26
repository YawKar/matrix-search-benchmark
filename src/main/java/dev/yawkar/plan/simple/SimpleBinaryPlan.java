package dev.yawkar.plan.simple;

import dev.yawkar.algorithm.SearchAlgorithm;
import dev.yawkar.algorithm.impl.BinaryOnRowLinearOnColumnSearch;

public class SimpleBinaryPlan extends SimplePlan {

    public SearchAlgorithm algorithm = new BinaryOnRowLinearOnColumnSearch();
}
