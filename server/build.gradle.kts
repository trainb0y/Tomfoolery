plugins {
    id("xyz.jpenilla.run-paper") version "2.0.1"
    id("org.jetbrains.kotlin.jvm") version "1.7.21"
    id("io.papermc.paperweight.userdev") version "1.3.11"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    mavenCentral()
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
}

dependencies {
    implementation(project(":common", "namedElements"))
    paperDevBundle("1.19.3-R0.1-SNAPSHOT")
    compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
}

// java { toolchain.languageVersion.set(JavaLanguageVersion.of(17)) }

tasks{
    shadowJar {
        minimize() // Will cause issues with Reflection
    }
    build {
        dependsOn(reobfJar)
    }
    runServer {
        minecraftVersion("1.19.3")
    }
}