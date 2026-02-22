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
        
        // İŞTE EKSİK OLAN VE HATAYI ÇÖZECEK KISIM BURASI:
        androidMain.dependencies {
            implementation("androidx.appcompat:appcompat:1.6.1")
            implementation("androidx.activity:activity-compose:1.8.2")
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

    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
}
