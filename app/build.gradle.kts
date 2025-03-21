plugins {
    alias(libs.plugins.jetbrainsKotlinKsp)
    alias(libs.plugins.hiltPlugin)

    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.pokemonapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pokemonapp"
        minSdk = 25
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
            excludes += "/META-INF/gradle/incremental.annotation.processors"

        }
    }
}
configurations.all {
    exclude(group = "com.intellij", module = "annotations")
}
dependencies {
implementation(libs.materialDialog)

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    implementation(libs.room.compiler)


    implementation (libs.coil)
    implementation (libs.coilnetwork)



    implementation (libs.hilt.android)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    ksp(libs.dagger.compiler)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.compiler)

    // implementation(libs.ext.compiler)
    implementation(libs.androidx.hilt.navigation.compose)



    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)



    implementation(libs.hilt.android)

    implementation(libs.retrofit.adapter.rxjava3)
    implementation(libs.lottie)
    implementation(libs.rxjava)
    implementation(libs.rxandroid)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.glide)
    implementation(libs.hilt.android)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)


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
}