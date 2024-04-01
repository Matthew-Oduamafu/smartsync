plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    alias(libs.plugins.kapt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.nerdbyte.solutions.smartsync"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nerdbyte.solutions.smartsync"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Hilt
    implementation(libs.hilt.android.core)
    implementation(libs.androidx.hilt.navigation.compose)
    kapt(libs.hilt.compiler)

//    implementation(libs.hilt.android)
//    implementation(libs.hilt.lifecycle.viewmodel)
//    kapt(libs.hilt.compiler)
//    implementation(libs.hilt.navigation.compose)

    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.play.services)

    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.runtime.ktx)

    implementation(libs.coil.compose)

    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.converter.gson)

    implementation(libs.room.runtime)
    kapt(libs.room.compiler)
    implementation(libs.room.ktx)
}