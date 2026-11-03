# DesideriumModTemplate

Mod development template for Minecraft 1.6.4 and DesideriumLoader, with Mixin support.

[中文](README.zh-CN.md)

## Installation

Create a repository with **Use this template**, then clone it. Scripts discover JDK 17 (Gradle 8.14.6 and compilation with `--release 8`) and JDK 8 (game runtime), downloading missing versions with SHA-256 verification. The first build requires internet access.

### Windows x64

```powershell
./setup.ps1
./build.ps1 genSources genIdeaRuns build
./build.ps1 runClient
# ./build.ps1 runServer
```

### Linux x86_64 (glibc)

```bash
./setup.sh
./build.sh genSources genIdeaRuns build
./build.sh runClient
# ./build.sh runServer
```

Build scripts run setup automatically on first use and forward arguments to the Gradle Wrapper. Setup reuses installed JDKs, including IntelliJ IDEA downloads and `JAVA8_HOME` / `JAVA17_HOME`, `JDK8` / `JDK17`. Missing versions are downloaded from Azul Zulu, verified against `gradle/jdks.lock.tsv`, and installed under `.jdks/8` and `.jdks/17`. Use `./setup.ps1 -Download` or `./setup.sh --download` to prefer project-local downloads.

Setup registers selected JDKs in `~/.jdks` using Windows directory junctions or Linux symbolic links; JDK files stay in their original locations. The tracked `gradle.properties` contains shared mod configuration and optional manual Toolchain overrides. Setup leaves it unchanged. Local selections are stored in `.jdks/homes.properties` and excluded from Git. Gradle selects JDK 17 using `gradle/gradle-daemon-jvm.properties`. Run setup again after moving the project to refresh JDK links.

Windows requires PowerShell 5.1 or later. Linux requires Bash, glibc, curl, tar, sha256sum and standard GNU utilities. Run setup before importing into IntelliJ IDEA to register JDKs for Gradle discovery; reload Gradle after generating sources. Direct Wrapper use remains available with configured JDKs.

## Customize

- Set `mod_id`, `mod_name` and `version` in `gradle.properties`, the project name in `settings.gradle`, and group in `build.gradle`.
- Set `mod_description`, `mod_authors` (comma-separated), `mod_url` and `mod_credits` in `gradle.properties`; `mcmod.info` is populated automatically, including the mod ID, name and version.
- Replace the example mod and Mixin in `src/main/java/example`. If you rename the package, also update the package in `src/main/resources/mod.mixins.json`.
- Keep the `@MOD_ID@`, `@MOD_NAME@` and `@MOD_VERSION@` string placeholders in the main class; Gradle replaces them in a source copy before compilation. Mixin config and refmap names are generated as `<mod_id>.mixins.json` and `<mod_id>.mixins.refmap.json`.

Build with `build`. The release JAR is `build/libs/<mod_id>-desiderium-1.6.4-<version>.jar`; the `-dev.jar` is for development only.
