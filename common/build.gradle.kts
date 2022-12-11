plugins {
    id("java")
    id("fabric-loom")
    id("org.jetbrains.kotlin.jvm") version "1.7.21"
}

group = "io.github.trainb0y.tomfoolery.common"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    minecraft("com.mojang:minecraft:${property("minecraft_version")}")
    mappings(loom.layered(){
        officialMojangMappings()
        "net.fabricmc:yarn:${property("yarn_mappings")}:v2"
    })
}

loom {
    splitEnvironmentSourceSets()
}