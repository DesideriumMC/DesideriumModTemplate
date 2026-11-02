# DesideriumModTemplate

面向 Minecraft 1.6.4 和 DesideriumLoader 的模组开发模板，支持 Mixin。

[English](README.md)

## Installation

使用 **Use this template** 创建仓库并克隆到本机。安装 **JDK 17** 用于 Gradle 和编译，安装 **Java 8** 用于运行游戏。首次构建需要联网。

### Windows

将 `JAVA_HOME` 设置为 JDK 17 的安装目录，在项目目录运行：

```powershell
./gradlew.bat genSources genIdeaRuns
./gradlew.bat build
```

启动客户端或服务端：

```powershell
./gradlew.bat runClient
./gradlew.bat runServer
```

### Linux

将 `JAVA_HOME` 设置为 JDK 17 的安装目录，在项目目录运行：

```bash
./gradlew genSources genIdeaRuns
./gradlew build
```

启动客户端或服务端：

```bash
./gradlew runClient
./gradlew runServer
```

如果未能识别 Java，在 `~/.gradle/gradle.properties`（Windows 为 `%USERPROFILE%/.gradle/gradle.properties`）中设置 `org.gradle.java.installations.paths`，填写 JDK 17 和 Java 8 的安装目录，以逗号分隔。

使用 IntelliJ IDEA 时，以 Gradle 项目导入，Gradle JVM 选择 JDK 17，生成源码后重新加载 Gradle。

## Customize

- 在 `gradle.properties` 中设置 `mod_id`、`mod_name` 和 `version`，在 `settings.gradle` 中设置项目名，在 `build.gradle` 中设置 group。
- 在 `gradle.properties` 中设置 `mod_description`、`mod_authors`（逗号分隔）、`mod_url` 和 `mod_credits`；`mcmod.info` 自动填充这些信息及模组 ID、名称和版本。
- 替换 `src/main/java/example` 中的示例模组和 Mixin。修改包名时，也要同步修改 `src/templates/java/example` 和 `src/main/resources/mod.mixins.json` 中的包名。
- 模组常量根据上述属性生成，Mixin 配置和 refmap 自动命名为 `<mod_id>.mixins.json`、`<mod_id>.mixins.refmap.json`。

使用 `build` 构建，正式产物为 `build/libs/<mod_id>-desiderium-1.6.4-<version>.jar`；`-dev.jar` 仅供开发使用。
