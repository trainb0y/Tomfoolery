include("client")
include("common")
include("server")
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
	plugins {
		id("fabric-loom") version "1.0-SNAPSHOT"
	}
}