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

- Set `mod_id`, `mod_name` and `version` in `gradle.properties`, the project name in `settings.gradle`, and group in `build.gradle`.
- Set `mod_description`, `mod_authors` (comma-separated), `mod_url` and `mod_credits` in `gradle.properties`; `mcmod.info` is populated automatically, including the mod ID, name and version.
- Replace the example mod and Mixin in `src/main/java/example`. If you rename the package, also update `src/templates/java/example` and the package in `src/main/resources/mod.mixins.json`.
- Mod constants are generated from these properties. Mixin config and refmap names are generated as `<mod_id>.mixins.json` and `<mod_id>.mixins.refmap.json`.

Build with `build`. The release JAR is `build/libs/<mod_id>-desiderium-1.6.4-<version>.jar`; the `-dev.jar` is for development only.
