plugins {
    id("java")
}

group = "org.java"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.register("prepareKotlinBuildScriptModel"){}

tasks.test {
    useJUnitPlatform()
}
