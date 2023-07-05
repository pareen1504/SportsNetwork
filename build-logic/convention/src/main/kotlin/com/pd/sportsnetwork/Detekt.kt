package com.pd.sportsnetwork

import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureDetekt(
    detektExtension: DetektExtension
) {
    detektExtension.apply {
        toolVersion(project)
        parallel = false
        config(project)
        buildUponDefaultConfig = false
        disableDefaultRuleSets = false
        debug = false
        ignoreFailures = false
        autoCorrect = true
    }
    detektPlugins()
}

/* TOOL VERSION */

fun DetektExtension.toolVersion(project: Project) {
    toolVersion = project.libs.findVersion("detekt").get().toString()
}

/* CONFIG */

fun DetektExtension.config(project: Project) {
    config = project.files("${project.rootDir}/config/quality/detekt.yml")
}

/* DETEKT PLUGINS */

fun Project.detektPlugins() {
    val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs")
    dependencies {
        add("detektPlugins", libs.findLibrary("detekt-formatting").get())
    }
}
