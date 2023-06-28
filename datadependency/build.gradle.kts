plugins {
    id("sportsnetwork.android.feature")
    id("sportsnetwork.kapt")
    id("sportsnetwork.android.hilt")
}

android {
    namespace = "com.pd.data"
}

dependencies {
    implementation(project(":features:feed:data"))
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}