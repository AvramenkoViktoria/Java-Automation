plugins {
    id("java")
}

group = "org.java"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":report-api"))
    implementation(project(":report-plugin"))
}
tasks.register("prepareKotlinBuildScriptModel"){}

tasks.test {
    useJUnitPlatform()
}