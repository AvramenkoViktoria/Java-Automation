package org.java;

public class ExecutionTimeReport implements ReportGenerator {

    @Override
    public String generateReport(Runnable target, int depth) {
        long start = System.nanoTime();
        target.run();
        long end = System.nanoTime();
        return "Execution time: " + (end - start) / 1_000_000.0 + " ms";
    }
}
