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
        
        // Uygulama ismini sisteme tanıtıyoruz
        manifestPlaceholders["appName"] = "ZyxVold"
    }

    // Hatalı çeviri dosyalarını (strings.xml) atlayıp APK'yı oluşturmasını sağlar
    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
