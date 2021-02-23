package com.koszoko.becomeexpert.falsesharing;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.GroupThreads;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

@Fork(value = 1)
@Warmup(iterations = 20)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class FalseSharingBenchmark {

    private static final Counter COUNTER = new Counter();
    private static final CounterAffectedByFalseSharing COUNTER_AFFECTED_BY_FALSE_SHARING = new CounterAffectedByFalseSharing();

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Group("contended")
    @GroupThreads(1)
    public long contendedIncrementA() {
        return COUNTER.incrementA();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Group("contended")
    @GroupThreads(1)
    public long contendedIncrementB() {
        return COUNTER.incrementB();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Group("falseSharing")
    @GroupThreads(1)
    public long incrementCounterA() {
        return COUNTER_AFFECTED_BY_FALSE_SHARING.incrementA();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Group("falseSharing")
    @GroupThreads(1)
    public long incrementCounterB() {
        return COUNTER_AFFECTED_BY_FALSE_SHARING.incrementB();
    }

}
