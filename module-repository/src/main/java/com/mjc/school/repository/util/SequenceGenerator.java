package com.mjc.school.repository.util;

import java.util.concurrent.atomic.AtomicLong;

public class SequenceGenerator {
    private static AtomicLong SEQUENCE = new AtomicLong(1);

    public static Long getNextSequence() {
        return SEQUENCE.getAndIncrement();
    }

}