package com.irfan.build_logic.convention.extentions

import com.android.build.api.dsl.CommonExtension
import com.android.kotlin.multiplatform.ide.models.serialization.androidTargetKey
import org.gradle.api.JavaVersion

@Suppress("UnstableApiUsage")
internal fun configureAndroid(commonExtension: CommonExtension<*, *, *, *, *>) {

    val appJavaVersion = JavaVersion.VERSION_17
    commonExtension.apply {
        compileSdk = 33

        defaultConfig {
            minSdk = 18
        }

        compileOptions {
            sourceCompatibility = appJavaVersion
            targetCompatibility = appJavaVersion
        }

        buildFeatures.buildConfig = false
    }
}