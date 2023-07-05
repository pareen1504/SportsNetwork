plugins {
    id("sportsnetwork.jvm.library")
    id("sportsnetwork.kapt")
    id("com.google.devtools.ksp")
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    compileOnly(libs.json)
    implementation(libs.hilt.core)
    kapt(libs.hilt.core.compiler)
    implementation(libs.moshi)
    ksp(libs.moshi.codegen)
}