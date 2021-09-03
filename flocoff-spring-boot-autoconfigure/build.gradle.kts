plugins {
    // Apply the java-library plugin for API and implementation separation.
    `java-library-conventions`
}

description = "flocoff-spring-boot-autoconfigure"

dependencies {
    implementation("org.springframework.boot:spring-boot-autoconfigure:2.4.5")
    implementation(project(":flocoff-core"))
    compileOnly("org.springframework:spring-web:5.3.6")
    compileOnly("org.springframework:spring-webflux:5.3.6")
    compileOnly("jakarta.servlet:jakarta.servlet-api:4.0.3")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.4.5")
    testImplementation("org.springframework.boot:spring-boot-starter-web:2.4.5")
    testImplementation("org.springframework.boot:spring-boot-starter-webflux:2.4.5")
    testImplementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.4.5")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}
