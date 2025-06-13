package org.java;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class GenerateReportPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.task("generateReports", task -> {
            task.setGroup("report");
            task.setDescription("Generates reports for all subdirectories with src folders");
            task.doLast(t -> {
                ReportGenerator reportGenerator = new ReportGenerator();
                reportGenerator.generateReports();
            });
        });
    }
}
