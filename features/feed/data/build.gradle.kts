plugins {
    id("sportsnetwork.jvm.library")
    id("jacoco")
    id("sportsnetwork.kapt")
    id("com.google.devtools.ksp")
}

dependencies {
    implementation(project(":common:jvm"))
    implementation(project(":features:feed:domain"))
    implementation(project(":core:network"))
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.moshi)
    implementation(libs.moshi.adapters)
    implementation(libs.hilt.core)
    kapt(libs.hilt.core.compiler)
    ksp(libs.moshi.codegen)
    implementation(libs.retrofit.core)

    testImplementation(libs.junit4)
    testImplementation(libs.kotestProperty)
    testImplementation(libs.mock.webserver)
    testImplementation(libs.retrofit.moshi.convertor)
    testImplementation(libs.mockK)
}
