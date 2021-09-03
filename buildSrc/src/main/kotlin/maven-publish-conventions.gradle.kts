plugins {
    `maven-publish`
    signing
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            pom {

            }
            from(components["java"])
        }
    }
}
