pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SportsNetwork"
include(":app")
include(":common:android")
include(":core:network")
include(":common:jvm")
include(":common:palette")
include(":features:feed")
include(":features:feed:data")
include(":features:feed:domain")
