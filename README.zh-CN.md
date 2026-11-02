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

- 在 `settings.gradle` 中设置项目名，在 `build.gradle` 中设置 group/version。
- 将 `src/main/java/example` 中的示例模组替换为自己的包名、模组 ID、名称和版本。
- 同步修改示例 Mixin 类、JSON 配置、refmap 名称及 `build.gradle` 中的对应配置。

使用 `build` 构建，正式模组 JAR 输出到 `build/libs/`；`-dev.jar` 仅供开发使用。
