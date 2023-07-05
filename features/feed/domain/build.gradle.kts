plugins {
    id("sportsnetwork.jvm.library")
    id("jacoco")
    id("sportsnetwork.kapt")
}

dependencies {
    implementation(project(":common:jvm"))
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.hilt.core)
    kapt(libs.hilt.core.compiler)
    testImplementation(libs.junit4)
    testImplementation(libs.kotestProperty)
}
