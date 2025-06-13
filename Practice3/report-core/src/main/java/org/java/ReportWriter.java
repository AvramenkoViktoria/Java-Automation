package org.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriter implements ReportWriterApi {
    @Override
    public void saveAsTxt() {
        ReportGenerator generator = new ReportGenerator();
        String report = generator.generateReports();
        File rootDir = new File(System.getProperty("user.dir"));
        File reportFile = new File(rootDir, "report.txt");
        try (FileWriter writer = new FileWriter(reportFile)) {
            writer.write(report);
            System.out.println("Report saved to: " + reportFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save report: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReportWriter reportWriter = new ReportWriter();
        reportWriter.saveAsTxt();
    }
}
