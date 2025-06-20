package org.java;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Elements;
import javax.tools.JavaFileObject;
import java.io.Writer;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AutoService(Processor.class)
@SupportedAnnotationTypes("org.java.GenerateHelper")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class HelperProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Elements elementUtils = processingEnv.getElementUtils();

        for (Element element : roundEnv.getElementsAnnotatedWith(GenerateHelper.class)) {
            if (element.getKind() != ElementKind.CLASS) continue;

            TypeElement classElement = (TypeElement) element;
            String className = classElement.getSimpleName().toString();
            String packageName = elementUtils.getPackageOf(classElement).toString();
            String builderClassName = className + "Builder";

            List<VariableElement> fields = classElement.getEnclosedElements().stream()
                    .filter(e -> e.getKind() == ElementKind.FIELD)
                    .map(e -> (VariableElement) e)
                    .collect(Collectors.toList());

            try {
                JavaFileObject file = processingEnv.getFiler()
                        .createSourceFile(packageName + "." + builderClassName);
                try (Writer writer = file.openWriter()) {
                    writer.write("package " + packageName + ";\n\n");
                    writer.write("public class " + builderClassName + " {\n");

                    for (VariableElement field : fields) {
                        writer.write("    private " + field.asType() + " " + field.getSimpleName() + ";\n");
                    }

                    for (VariableElement field : fields) {
                        String fieldName = field.getSimpleName().toString();
                        String type = field.asType().toString();
                        writer.write("\n    public " + builderClassName + " set" + capitalize(fieldName) +
                                     "(" + type + " " + fieldName + ") {\n" +
                                     "        this." + fieldName + " = " + fieldName + ";\n" +
                                     "        return this;\n    }\n");
                    }

                    writer.write("\n    public " + className + " build() {\n");
                    writer.write("        return new " + className + "(");
                    writer.write(fields.stream()
                                         .map(f -> f.getSimpleName().toString())
                                         .collect(Collectors.joining(", ")) + ");\n");
                    writer.write("    }\n}\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private String capitalize(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}
