package com.pd.sportsnetwork

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*,*,*,*>
) {
    commonExtension.apply {
        compileSdk = 33

        defaultConfig {
            minSdk = 21
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        configureKotlin()
        lint(project)
        testOptions()
    }
}

internal fun Project.configureKotlinJvm() {
    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    configureKotlin()
}

private fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
            freeCompilerArgs += kotlinFreeCompilerArgs
        }
    }
}

/* LINT */

fun CommonExtension<*, *, *, *>.lint(project: Project) {
    lint {
        abortOnError = true
        checkAllWarnings = true
        ignoreWarnings = false
        checkReleaseBuilds = true
        checkDependencies = true
        warningsAsErrors = true
        lintConfig = project.file("${project.rootDir}/config/quality/lint.xml")
        htmlReport = true
        xmlReport = true
        disable += disabledIssues
    }
}

/* TEST OPTIONS */

@Suppress("UnstableApiUsage")
fun CommonExtension<*, *, *, *>.testOptions() {
    testOptions {
        animationsDisabled = true
        unitTests.isIncludeAndroidResources = true
        unitTests.all { test: Test -> test.testLogging }
    }
}