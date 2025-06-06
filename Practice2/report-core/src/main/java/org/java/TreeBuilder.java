package org.java;

public class TreeBuilder {

    private static int recursionCalls = 0;

    public static void resetCounter() {
        recursionCalls = 0;
    }

    public static int getCounter() {
        return recursionCalls;
    }

    public static void build(int depth) {
        recursionCalls++;
        if (depth <= 0) return;

        build(depth - 1);
        build(depth - 1);
    }
}
