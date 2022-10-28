package dev.yawkar;

import com.github.sh0nk.matplotlib4j.Plot;
import dev.yawkar.benchmark.MatrixSearchBenchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final List<Integer> sequenceOfNumbersOfRows = IntStream.range(1, 14).map(i -> (1 << i)).boxed().toList();

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(MatrixSearchBenchmark.class.getSimpleName())
                .build();
        var results = new Runner(options).run();
        var labeledResults = results.stream()
                .collect(
                        Collectors.groupingBy(r -> r.getPrimaryResult().getLabel(),
                                Collectors.mapping(r -> r.getPrimaryResult().getScore(),
                                        Collectors.toList())));
        Plot plot = Plot.create();
        plot.xlabel("Number of rows (number of columns is constant 8192)");
        plot.ylabel("ns/op");
        plot.title("Performance comparison on AlphaMatrices");
        for (var labelResult : labeledResults.entrySet()) {
            if (labelResult.getKey().startsWith("alpha")) {
                plot.plot().label(labelResult.getKey()).add(sequenceOfNumbersOfRows, labelResult.getValue());
            }
        }
        plot.legend().loc("upper left");
        plot.show();

        Plot plot2 = Plot.create();
        plot2.xlabel("Number of rows (number of columns is constant 8192)");
        plot2.ylabel("ns/op");
        plot2.title("Performance comparison on BetaMatrices");
        for (var labelResult : labeledResults.entrySet()) {
            if (labelResult.getKey().startsWith("beta")) {
                plot2.plot().label(labelResult.getKey()).add(sequenceOfNumbersOfRows, labelResult.getValue());
            }
        }
        plot2.legend().loc("upper left");
        plot2.show();

        Plot plot3 = Plot.create();
        plot3.xlabel("Number of rows (number of columns is constant 8192)");
        plot3.ylabel("ln(ns/op)");
        plot3.title("Semi-Log performance comparison on AlphaMatrices");
        for (var labelResult : labeledResults.entrySet()) {
            if (labelResult.getKey().startsWith("alpha")) {
                plot3.plot().label(labelResult.getKey()).add(sequenceOfNumbersOfRows, labelResult.getValue().stream().mapToDouble(Math::log).boxed().toList());
            }
        }
        plot3.legend().loc("upper left");
        plot3.show();

        Plot plot4 = Plot.create();
        plot4.xlabel("Number of rows (number of columns is constant 8192)");
        plot4.ylabel("ln(ns/op)");
        plot4.title("Semi-Log performance comparison on BetaMatrices");
        for (var labelResult : labeledResults.entrySet()) {
            if (labelResult.getKey().startsWith("beta")) {
                plot4.plot().label(labelResult.getKey()).add(sequenceOfNumbersOfRows, labelResult.getValue().stream().mapToDouble(Math::log).boxed().toList());
            }
        }
        plot4.legend().loc("upper left");
        plot4.show();
    }
}