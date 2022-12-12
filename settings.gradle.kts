rootProject.name = "tomfoolery"
pluginManagement {
	repositories {
		mavenCentral()
		gradlePluginPortal()
		maven("https://maven.fabricmc.net/") {
			name = "Fabric"
		}
		maven("https://papermc.io/repo/repository/maven-public/") {
			name = "Paper"
		}
	}
	@Suppress("LocalVariableName")
	plugins {
		val paperweight_version: String by settings
		val loom_version: String by settings
		val kotlin_version: String by settings
		val run_paper_version: String by settings
		val shadow_version: String by settings

		id("fabric-loom") version loom_version
		id("xyz.jpenilla.run-paper") version run_paper_version
		id("io.papermc.paperweight.userdev") version paperweight_version
		id("com.github.johnrengelman.shadow") version shadow_version
		kotlin("jvm") version kotlin_version
	}
}
include("client")
include("common")
include("server")