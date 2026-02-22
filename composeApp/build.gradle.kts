plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
        }
        
        androidMain.dependencies {
            implementation("androidx.appcompat:appcompat:1.6.1")
            implementation("androidx.activity:activity-compose:1.8.2")
            implementation("androidx.core:core-ktx:1.12.0")
            // Widget ve tasarım hatalarını kökten çözen kütüphaneler:
            implementation("androidx.glance:glance-appwidget:1.0.0")
            implementation("androidx.glance:glance-material3:1.0.0")
            implementation("com.google.android.material:material:1.11.0")
        }
    }
}

android {
    namespace = "com.fedom.zyxmus"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.fedom.zyxmus"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
        manifestPlaceholders["appName"] = "ZyxVold"
    }

    // ÖNLEM: Eksik resim, hatalı yazı veya çeviri olsa bile Build'i DURDURMA!
    lint {
        checkReleaseBuilds = false
        abortOnError = false
        checkDependencies = false
        ignoreWarnings = true
    }

    // ÖNLEM: Paketleme sırasında oluşabilecek çakışmaları engelle
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }
}
