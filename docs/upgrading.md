# Upgrading the Intellij Platform

There's a few things that likely need to be upgraded together. Firstly, there's the intellij platform plugin version.

- IntelliJ platform version
  - JBR (JetBrains runtime) version exactly
    - requires a minimum java SDK version
      - https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html#platformVersions
  - kotlin stdlib version exactly
    - requires a specific gradle plugin version
      - https://plugins.jetbrains.com/docs/intellij/using-kotlin.html#kotlin-standard-library
  - requires a minimum intellij platform gradle plugin
    - https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html#usage

The JetBrains runtime (jbr) is bundled with the IDE, so it should never need to be downloaded outside of gradle 
tasks. When you specify the platform version, you implicitly select a JBR version. *However*, IntelliJ will change 
the required java version for some JBRs. 

Additionally, the Kotlin stdlib is bundled with the IDE as well. In order to build valid kotlin, we need a specific 
kotlin gradle plugin version

Intellij Makes the claim that the intellij platform plugin for gradle is fully backwards compatible, but we all know 
how that goes. Nonetheless, there's definitely a minimum plugin version for some versions of the platform.

## IntelliJ Platform version

The Intellij platform is versioned off of the IDE version using the `2023.2` == `232.something.something` pattern. 
There 
are two places to set this value.

  - [build.gradle](../build.gradle) `intellij.version = '232'`
  - [plugin.xml](../src/main/resources/META-INF/plugin.xml)
    - `<idea-version since-build="232"/>`
    - unfortunately, [build.gradle](../build.gradle) `patchPluginXml.sinceBuild = '232'` 

## JBR

The JetBrains runtime specifies a minimum java version. In order to generate consistent code, we have to tell kotlin 
which version of the java it needs to be compatible with in [build.gradle](../build.gradle)

```groovy
compileKotlin {
    kotlinOptions.jvmTarget = "11"
}
compileTestKotlin {
    kotlinOptions.jvmTarget = "11"
}
```

## Kotlin stdlib

This is specified in the gradle plugin [build.gradle](../build.gradle)

```
plugins {
    id 'org.jetbrains.kotlin.jvm' version '1.6.21'
}
```

## Gradle JVM

### Local Development
In IntelliJ IDEA, you need to
1. go to Settings
2. "Build, Execution, Deployment" -> "Build Tools" -> "Gradle" and modify
3. "Gradle JVM" select an SDK from the dropdown. I suggest "Project SDK"

and/or
1. go to "File" -> "Project structure..."
2. "Project Settings" -> "project"
3. set "Project SDK"

By default, IntelliJ wants to set it to the current IDE's JetBrains runtime, but I usually use an IDE much newer 
than the oldest one I support. So I recommend downloading something like IBM's semeru for the java version the 
platform supports.

### GitHub actions
In the Github actions, you'll need to update both [build.yml](../.github/workflows/build.yml) and 
[test.yml](../.github/workflows/test.yml)

```yaml
steps:
  - name: Set up JDK 11
    uses: actions/setup-java@v3
    with:
      distribution: semeru
      java-version: 11
      java-package: jdk
```

`distribution` should probably match what's used in IntelliJ IDEA. Documentation for setup-java is at its github 
https://github.com/actions/setup-java.

## Intellij Gradle plugin version

```groovy
plugins {
    id "org.jetbrains.intellij" version "1.16.0"
}
```
