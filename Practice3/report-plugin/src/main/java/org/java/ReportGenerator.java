package org.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {

    public String generateReports() {
        File currentDir = new File(System.getProperty("user.dir"));
        List<File> dirsWithSrc = findDirsWithSrc(currentDir);

        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Found directories with 'src':\n");

        for (File dir : dirsWithSrc) {
            reportBuilder.append("- ").append(dir.getAbsolutePath()).append("\n");
            reportBuilder.append(generateReport(dir));
        }

        return reportBuilder.toString();
    }

    private List<File> findDirsWithSrc(File dir) {
        List<File> result = new ArrayList<>();
        if (dir == null || !dir.isDirectory())
            return result;
        File srcDir = new File(dir, "src");
        if (srcDir.exists() && srcDir.isDirectory())
            result.add(dir);
        File[] subdirs = dir.listFiles(File::isDirectory);
        if (subdirs != null)
            for (File subdir : subdirs)
                result.addAll(findDirsWithSrc(subdir));
        return result;
    }

    public String generateReport(File dir) {
        StringBuilder builder = new StringBuilder();

        if (dir == null || !dir.isDirectory()) {
            builder.append("Invalid directory\n");
            return builder.toString();
        }

        File[] files = dir.listFiles();
        if (files == null) return builder.toString();

        for (File file : files) {
            if (file.isDirectory()) {
                File srcFolder = new File(file, "src");
                if (srcFolder.exists() && srcFolder.isDirectory()) {
                    builder.append("  Found src folder in: ")
                            .append(file.getAbsolutePath())
                            .append("\n");
                }
                builder.append(generateReport(file));
            }
        }

        return builder.toString();
    }
}
