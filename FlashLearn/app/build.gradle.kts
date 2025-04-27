plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.flashlearn"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.flashlearn"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    // Jetpack compose UI
    implementation(libs.ui)
    implementation(libs.material3)
    implementation(libs.ui.tooling.preview)
    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.androidx.runtime.livedata)
    debugImplementation(libs.ui.tooling)
    // View Model Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    // Navigation
    implementation(libs.androidx.navigation.compose)
    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    // Lottie Animation
    implementation(libs.lottie.compose)
    // DataStore
    implementation(libs.androidx.datastore.preferences)
    // Material 3
    implementation (libs.androidx.compose.material3.material3)
    // Material
    implementation (libs.material)
    // Room Database
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    // Hilt Dependencies Injection
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation (libs.androidx.hilt.navigation.compose)
    // Chart
    implementation (libs.mpandroidchart)
    // WorkManager
    implementation (libs.androidx.work.runtime.ktx)
    // Firebase
    implementation(platform(libs.firebase.bom))
    // Firebase Authentication
    implementation(libs.firebase.auth)
    implementation (libs.play.services.auth)
    // Firebase Database
    implementation (libs.firebase.database.ktx)
    // Coil
    implementation(libs.coil.compose)


    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

}