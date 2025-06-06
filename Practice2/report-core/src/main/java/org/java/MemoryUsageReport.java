package org.java;

public class MemoryUsageReport implements ReportGenerator {

    @Override
    public String generateReport(Runnable target, int depth) {
        System.gc();
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        target.run();
        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        return "Memory used: " + (after - before) / 1024 + " KB";
    }
}
