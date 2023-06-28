plugins {
    id("sportsnetwork.jvm.library")
    id("sportsnetwork.kapt")
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    compileOnly(libs.json)
    implementation(libs.hilt.core)
    kapt(libs.hilt.core.compiler)
    implementation(libs.moshi)
    kapt(libs.moshi.codegen)
}