package dev.yawkar;

import dev.yawkar.benchmark.MatrixSearchBenchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(MatrixSearchBenchmark.class.getSimpleName())
                .build();
        new Runner(options).run();
    }
}