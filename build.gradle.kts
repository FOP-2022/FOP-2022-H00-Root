plugins {
  java
}
allprojects {
  apply(plugin = "java")
  repositories {
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
    mavenCentral()
  }
  java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    withSourcesJar()
  }
  tasks {
    jar {
      archiveFileName.set("${rootProject.name}-${project.name}.jar")
    }
    named<Jar>("sourcesJar") {
      archiveFileName.set("${rootProject.name}-${project.name}-sources.jar")
    }
  }
  dependencies {
    implementation("org.sourcegrade:fopbot:0.1.0-SNAPSHOT")
  }
}
