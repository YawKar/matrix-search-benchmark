package dev.yawkar.benchmark;

import dev.yawkar.plan.AlphaBinaryPlan;
import dev.yawkar.plan.AlphaLinearPlan;
import dev.yawkar.plan.BetaBinaryPlan;
import dev.yawkar.plan.BetaLinearPlan;
import dev.yawkar.plan.simple.SimplePlan;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 0)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 1)
public class MatrixSearchBenchmark {

    private static long get2N_plus_one_target(SimplePlan plan) {
        return 2L * plan.matrix[0].length + 1;
    }

    private static long get16N_plus_one_target(SimplePlan plan) {
        return 16L * plan.matrix[0].length + 1;
    }

    @Benchmark
    public void alpha_linear(AlphaLinearPlan plan) {
        plan.algorithm.search(plan.matrix, get2N_plus_one_target(plan));
    }

    @Benchmark
    public void beta_linear(BetaLinearPlan plan) {
        plan.algorithm.search(plan.matrix, get16N_plus_one_target(plan));
    }

    @Benchmark
    public void alpha_binary(AlphaBinaryPlan plan) {
        plan.algorithm.search(plan.matrix, get2N_plus_one_target(plan));
    }

    @Benchmark
    public void beta_binary(BetaBinaryPlan plan) {
        plan.algorithm.search(plan.matrix, get16N_plus_one_target(plan));
    }
}

