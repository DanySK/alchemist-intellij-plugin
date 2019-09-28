import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version Versions.kotlin_scripting_compiler_embeddable
    id("org.jlleitschuh.gradle.ktlint") version Versions.org_jlleitschuh_gradle_ktlint_gradle_plugin
    id("org.jetbrains.dokka") version Versions.org_jetbrains_dokka_gradle_plugin
    id("org.jetbrains.intellij") version Versions.org_jetbrains_intellij_gradle_plugin
    id("com.gradle.build-scan") version Versions.com_gradle_build_scan_gradle_plugin
    id("de.fayard.buildSrcVersions") version Versions.de_fayard_buildsrcversions_gradle_plugin
    id("org.danilopianini.git-sensitive-semantic-versioning") version Versions.org_danilopianini_git_sensitive_semantic_versioning_gradle_plugin
}

repositories {
    jcenter()
}

dependencies {
    implementation(Libs.classgraph)
}

intellij {
    version = "2019.1"
    setPlugins("gradle")
}

buildScan {
}

gitSemVer {
    version = computeGitSemVer() // THIS IS MANDATORY, AND MUST BE LAST IN BLOCK
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}