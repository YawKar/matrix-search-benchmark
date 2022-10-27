package dev.yawkar.plan.simple;

import dev.yawkar.algorithm.SearchAlgorithm;
import dev.yawkar.algorithm.impl.ExpBinaryOnRowLinearOnColumnSearch;

public class SimpleExpBinaryPlan extends SimplePlan {

    public SearchAlgorithm algorithm = new ExpBinaryOnRowLinearOnColumnSearch();
}
