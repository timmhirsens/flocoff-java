plugins {
    `java-library-conventions`
}

description = "flocoff-core"

dependencies {
    compileOnly("jakarta.servlet:jakarta.servlet-api:4.0.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}
