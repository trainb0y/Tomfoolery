plugins {
    java
    kotlin("jvm")
    id("xyz.jpenilla.run-paper")
    id("io.papermc.paperweight.userdev")
    id("com.github.johnrengelman.shadow")
}
version = property("mod_version")!!
repositories {
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
}

dependencies {
    implementation(project(":common", "namedElements"))
    paperDevBundle("${property("minecraft_version")}-R0.1-SNAPSHOT")
    compileOnly("io.papermc.paper:paper-api:${property("minecraft_version")}-R0.1-SNAPSHOT")
}

tasks{
    build {
        dependsOn(reobfJar)
    }
    runServer {
        minecraftVersion(property("minecraft_version").toString())
    }
    processResources {
        inputs.property("version", version)
        filesMatching("plugin.yml") {
            expand(mutableMapOf("version" to version))
        }
    }
}