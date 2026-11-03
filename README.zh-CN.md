# DesideriumModTemplate

面向 Minecraft 1.6.4 和 DesideriumLoader 的模组开发模板，支持 Mixin。

[English](README.md)

## Installation

使用 **Use this template** 创建仓库并克隆。脚本自动发现 JDK 17（Gradle 8.14.6 与编译，`--release 8`）和 JDK 8（游戏运行）；缺失版本自动下载并校验 SHA-256。首次构建需要联网。

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

构建脚本首次使用时自动执行 setup，并将参数传递给 Gradle Wrapper。Setup 复用已安装的 JDK，包括 IntelliJ IDEA 下载目录及 `JAVA8_HOME` / `JAVA17_HOME`、`JDK8` / `JDK17` 环境变量；缺失版本从 Azul Zulu 下载，按 `gradle/jdks.lock.tsv` 校验后安装到 `.jdks/8` 和 `.jdks/17`。使用 `./setup.ps1 -Download` 或 `./setup.sh --download` 可优先使用项目内下载的 JDK。

Setup 通过 Windows 目录联接或 Linux 符号链接，将选定的 JDK 注册到 `~/.jdks`，JDK 文件保留在原位置。`gradle.properties` 纳入 Git，保存共享模组配置及可选的手工 Toolchain 配置，setup 不再修改它。本地 JDK 选择记录在 `.jdks/homes.properties`，不纳入 Git。Gradle 通过 `gradle/gradle-daemon-jvm.properties` 选择 JDK 17。移动项目后请重新运行 setup 刷新 JDK 链接。

Windows 需要 PowerShell 5.1 或更新版本；Linux 需要 Bash、glibc、curl、tar、sha256sum 和标准 GNU 工具。导入 IntelliJ IDEA 前运行 setup 注册 JDK 供 Gradle 自动发现，生成源码后重新加载 Gradle。配置好 JDK 后仍可直接使用 Wrapper。

## Customize

- 在 `gradle.properties` 中设置 `mod_id`、`mod_name` 和 `version`，在 `settings.gradle` 中设置项目名，在 `build.gradle` 中设置 group。
- 在 `gradle.properties` 中设置 `mod_description`、`mod_authors`（逗号分隔）、`mod_url` 和 `mod_credits`；`mcmod.info` 自动填充这些信息及模组 ID、名称和版本。
- 替换 `src/main/java/example` 中的示例模组和 Mixin。修改包名时，也要同步修改 `src/main/resources/mod.mixins.json` 中的包名。
- 保留主类中的 `@MOD_ID@`、`@MOD_NAME@` 和 `@MOD_VERSION@` 字符串占位符，Gradle 在编译前替换源码副本中的对应值。Mixin 配置和 refmap 自动命名为 `<mod_id>.mixins.json`、`<mod_id>.mixins.refmap.json`。

使用 `build` 构建，正式产物为 `build/libs/<mod_id>-desiderium-1.6.4-<version>.jar`；`-dev.jar` 仅供开发使用。
