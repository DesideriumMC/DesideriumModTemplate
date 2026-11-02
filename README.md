# DesideriumModTemplate

Mod development template for Minecraft 1.6.4 and DesideriumLoader, with Mixin support.

[中文](README.zh-CN.md)

## Installation

Create a repository with **Use this template**, then clone it. Install **JDK 17** for Gradle and compilation, and **Java 8** to run the game. The first build requires an internet connection.

### Windows

Set `JAVA_HOME` to your JDK 17 installation, then run in the project directory:

```powershell
./gradlew.bat genSources genIdeaRuns
./gradlew.bat build
```

Launch the client or server:

```powershell
./gradlew.bat runClient
./gradlew.bat runServer
```

### Linux

Set `JAVA_HOME` to your JDK 17 installation, then run in the project directory:

```bash
./gradlew genSources genIdeaRuns
./gradlew build
```

Launch the client or server:

```bash
./gradlew runClient
./gradlew runServer
```

If Java is not detected, set `org.gradle.java.installations.paths` to your JDK 17 and Java 8 installation directories, separated by a comma, in `~/.gradle/gradle.properties` (`%USERPROFILE%/.gradle/gradle.properties` on Windows).

For IntelliJ IDEA, import the project as a Gradle project, select JDK 17 as the Gradle JVM, and reload Gradle after generating sources.

## Customize

- Set the project name in `settings.gradle` and group/version in `build.gradle`.
- Replace the example mod in `src/main/java/example` with your own package, mod ID, name and version.
- Update the example Mixin class, JSON configuration and refmap names together with their entries in `build.gradle`.

Build with `build`. The release JAR is in `build/libs/`; the `-dev.jar` is for development only.
