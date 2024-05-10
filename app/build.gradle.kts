plugins {
    alias(libs.plugins.irfan.android.application)
   // alias(libs.plugins.irfan.android.compose)
}

android {
    namespace = "com.irfan.modularization"

    defaultConfig {
        applicationId = "com.irfan.modularization"
    }
}



dependencies {
    implementation(project(":feature:listing"))
    implementation(project(":feature:details"))
}