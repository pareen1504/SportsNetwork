plugins {
    id("sportsnetwork.android.application")
    id("sportsnetwork.android.application.compose")
    id("sportsnetwork.kapt")
    id("sportsnetwork.android.hilt")
    id("com.google.devtools.ksp")
}

android {
    defaultConfig {
        applicationId = "com.pd.sportsnetwork"
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
        }
        release {
            isMinifyEnabled = false
            applicationIdSuffix = ".release"
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    namespace = "com.pd.sportsnetwork"
}

dependencies {
    implementation(project(":common:android"))
    implementation(project(":common:palette"))
    implementation(project(":core:network"))
    implementation(project(":features:feed"))
    implementation(project(":features:feed:data"))
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.androidx.core.splashscreen)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.androidx.activity.compose)
}