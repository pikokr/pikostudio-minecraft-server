plugins {
    kotlin("jvm") version "1.4.21"
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "com.github.johnrengelman.shadow")

    repositories {
        maven(url = "https://papermc.io/repo/repository/maven-public/")
        maven(url = "https://jitpack.io/")
        maven(url = "https://repo.dmulloy2.net/nexus/repository/public/")
    }

    fun DependencyHandlerScope.implementationOnlyCore(dependencyNotation: Any): Dependency? {
        return if (this@subprojects == this@subprojects.project(":core"))
            implementation(dependencyNotation)
        else
            compileOnly(dependencyNotation)
    }

    dependencies {
        compileOnly(kotlin("stdlib-jdk8"))
        compileOnly("com.destroystokyo.paper:paper-api:1.16.4-R0.1-SNAPSHOT")
        implementationOnlyCore("com.github.noonmaru:kommand:0.6.3")
        implementationOnlyCore("com.github.noonmaru:tap:3.2.7")
        implementationOnlyCore("com.comphenix.protocol:ProtocolLib:4.5.0")
    }

    tasks {
        compileJava {
            options.encoding = "UTF-8"
        }
        javadoc {
            options.encoding = "UTF-8"
        }
        compileKotlin {
            kotlinOptions.jvmTarget = "1.8"
        }
        compileTestKotlin {
            kotlinOptions.jvmTarget = "1.8"
        }
        processResources {
            filesMatching("*.yml") {
                expand(project.properties)
            }
        }
        shadowJar {
            archiveClassifier.set("")
            archiveVersion.set("")
        }
        assemble {
            dependsOn(shadowJar)
        }

        create<Copy>("installToServer") {
            from(shadowJar)
            var dest = File(rootDir, "server/plugins")
            if (File(dest, shadowJar.get().archiveFileName.get()).exists()) dest = File(dest, "update")
            into(dest)
            doLast { println("${shadowJar.get().archiveFileName.get()} copied to ${dest.path}") }
        }
    }
}

gradle.buildFinished { buildDir.deleteRecursively() }
