plugins {
    alias(libs.plugins.irfan.android.application)
    alias(libs.plugins.irfan.android.compose)
}

android {
    namespace = "com.irfan.modularization"

    defaultConfig {
        applicationId = "com.irfan.modularization"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(project(":feature:listing"))
    implementation(project(":feature:details"))
}