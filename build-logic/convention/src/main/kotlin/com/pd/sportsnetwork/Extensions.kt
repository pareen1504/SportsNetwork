package com.pd.sportsnetwork

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

inline val kotlinFreeCompilerArgs: List<String>
    get() = listOf(
        "-opt-in=kotlin.RequiresOptIn",
        "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
        "-opt-in=kotlinx.coroutines.FlowPreview",
    )

val disabledIssues = arrayOf(
    "UnusedIds", // Because of UAST
    "InvalidPackage",
    "DialogFragmentCallbacksDetector", // From Android Gradle Plugin version 7.4.0-alpha02 and onwards
    "UnknownIssueId", // From Android Gradle Plugin version 7.4.0-alpha02 and onwards
    "GradleDependency",
    "AndroidGradlePluginVersion",
    "NewerVersionAvailable",
)
