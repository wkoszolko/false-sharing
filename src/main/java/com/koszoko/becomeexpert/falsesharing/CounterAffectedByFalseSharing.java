package com.koszoko.becomeexpert.falsesharing;

import java.util.concurrent.atomic.AtomicLong;

public class CounterAffectedByFalseSharing {
    private volatile AtomicLong counterA = new AtomicLong();
    private volatile AtomicLong counterB = new AtomicLong();

    public long incrementA() {
        return counterA.incrementAndGet();
    }

    public long incrementB() {
        return counterB.incrementAndGet();
    }
}
