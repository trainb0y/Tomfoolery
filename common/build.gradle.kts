plugins {
    java
    kotlin("jvm")
    id("fabric-loom")
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