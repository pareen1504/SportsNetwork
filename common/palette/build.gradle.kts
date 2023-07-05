plugins {
    id("sportsnetwork.android.feature")
    id("sportsnetwork.android.library.compose")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    
    namespace = "com.pd.palette"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    api(libs.androidx.material)
    api(libs.accompanist.systemuicontroller)
    implementation(libs.androidx.core.ktx)
}