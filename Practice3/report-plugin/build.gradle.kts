plugins {
    `java-gradle-plugin`
}

group = "org.java"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

gradlePlugin {
    plugins {
        create("reportPlugin") {
            id = "org.java.report-plugin"
            implementationClass = "org.java.GenerateReportPlugin"
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
