import org.gradle.kotlin.dsl.support.compileKotlinScriptModuleTo

plugins {  }

allprojects {
    group = "de.timmhirsens.flocoff"
    version = "1.0.0"

    repositories {
        // Use Maven Central for resolving dependencies.
        mavenCentral()
    }

}
