plugins {
    `java-library`
}

apply(plugin="maven-publish-conventions")

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    withJavadocJar()
    withSourcesJar()
}

tasks.test {
    useJUnitPlatform()
}
