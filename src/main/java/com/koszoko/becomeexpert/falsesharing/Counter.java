package com.koszoko.becomeexpert.falsesharing;

import jdk.internal.vm.annotation.Contended;

public class Counter {
    private volatile long counterA = 0L;
    private volatile long counterB = 0L;

    public long incrementA() {
        return counterA++;
    }

    public long incrementB() {
        return counterB++;
    }
}
