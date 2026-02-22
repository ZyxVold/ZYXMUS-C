plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    androidTarget()
}

android {
    namespace = "com.fedom.compose.persist"
    compileSdk = 35
}
