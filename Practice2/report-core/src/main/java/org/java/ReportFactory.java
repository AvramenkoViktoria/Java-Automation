package org.java;

public class ReportFactory {

    public static ReportGenerator createReport(String type) {
        return switch (type.toLowerCase()) {
            case "time" -> new ExecutionTimeReport();
            case "memory" -> new MemoryUsageReport();
            default -> throw new IllegalArgumentException("Unknown report type: " + type);
        };
    }
}
