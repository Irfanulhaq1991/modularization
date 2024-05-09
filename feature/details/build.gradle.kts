@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.irfan.android.library)
    alias(libs.plugins.irfan.android.compose)
}

android {
    namespace = "com.irfan.feature.details"
}