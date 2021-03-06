// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(BuildPlugins.gradle)
        classpath(BuildPlugins.kotlin)
        classpath(BuildPlugins.butterKnifeGradle)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts.kts.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()

        mavenCentral()
    }
}

tasks.register("clean").configure {
    delete("build")
}