plugins {
    kotlin("jvm") version "1.4.21"
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "com.github.johnrengelman.shadow")

    repositories {
        maven(url = "https://papermc.io/repo/repository/maven-public/")
        maven(url = "https://jitpack.io/")
    }

    dependencies {
        compileOnly(kotlin("stdlib-jdk8"))
        compileOnly("com.destroystokyo.paper:paper-api:1.16.4-R0.1-SNAPSHOT")
    }
}