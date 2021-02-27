package com.koszoko.becomeexpert.falsesharing;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;

@Fork(value = 1, jvmArgs = "-XX:-RestrictContended")
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class FalseSharingBenchmark {

    private static volatile long simpleLongCounter = 0L;
    private static final Counter COUNTER = new Counter();
    private static final CounterAffectedByFalseSharing COUNTER_AFFECTED_BY_FALSE_SHARING = new CounterAffectedByFalseSharing();

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Group("longCounter")
    @GroupThreads(1)
    public long incrementLong() {
        return simpleLongCounter++;
    }

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
