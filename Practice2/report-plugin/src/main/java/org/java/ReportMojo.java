package org.java;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.List;

@Mojo(name = "generate-report", defaultPhase = LifecyclePhase.VERIFY)
public class ReportMojo extends AbstractMojo {

    @Parameter(property = "type", defaultValue = "full")
    private String type;

    @Parameter(property = "depth", defaultValue = "30")
    private int depth;

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("Generating report of type: " + type);
        Runnable testFunction = () -> TreeBuilder.build(depth);

        List<String> typesToRun = switch (type) {
            case "full" -> List.of("time", "memory");
            default -> List.of(type);
        };

        for (String t : typesToRun) {
            ReportGenerator generator = ReportFactory.createReport(t);
            String result = generator.generateReport(testFunction, depth);
            getLog().info("[" + t + "]: " + result);
        }
    }
}

