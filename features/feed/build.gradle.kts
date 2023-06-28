plugins {
    id("sportsnetwork.android.feature")
    id("sportsnetwork.android.library.compose")
}

android {
    namespace = "com.pd.sportsnetwork.features.feed"
}

dependencies {
    implementation(project(":common:jvm"))
    implementation(project(":common:android"))
    implementation(project(":common:palette"))
    implementation(project(":features:feed:domain"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.appcompat)
    implementation(libs.material)
}
