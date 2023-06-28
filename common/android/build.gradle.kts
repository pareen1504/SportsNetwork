plugins {
    id("sportsnetwork.android.library")
    id("sportsnetwork.android.library.compose")
    id("sportsnetwork.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.pd.common"
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":common:palette"))
    implementation(libs.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
}
