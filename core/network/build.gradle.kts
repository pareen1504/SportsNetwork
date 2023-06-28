plugins {
    id("sportsnetwork.jvm.library")
    id("sportsnetwork.kapt")
}

dependencies {
    implementation(libs.retrofit.core)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.moshi.convertor)
    implementation(libs.hilt.core)
    implementation(libs.kotlinx.coroutines.core)
    kapt(libs.hilt.core.compiler)
    compileOnly(libs.json)
}
