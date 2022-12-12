plugins {
	java
}

repositories {
	mavenCentral()
}
allprojects {
	repositories {
		mavenCentral()
		maven(uri("https://jitpack.io"))
	}
	dependencies {

	}
}
tasks {
	build {
		doLast {
			copy {
				from("client/build/libs/client-${project.property("mod_version")}.jar")
				into("build/")
			}
			copy {
				from("server/build/libs/server-${project.property("mod_version")}.jar")
				into("build/")
			}
		}
	}
}