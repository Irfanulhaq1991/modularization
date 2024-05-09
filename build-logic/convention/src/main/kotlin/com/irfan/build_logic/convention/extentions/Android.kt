package com.irfan.build_logic.convention.extentions

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.android.kotlin.multiplatform.ide.models.serialization.androidTargetKey
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("UnstableApiUsage")
internal fun Project.configureAndroid(commonExtension: CommonExtension<*, *, *, *, *>) {

    val appJavaVersion = JavaVersion.VERSION_17
    commonExtension.apply {
        compileSdk = 34

        defaultConfig.minSdk = 21
        defaultConfig {
            version = 1
            minSdk = 21
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

            if (commonExtension is BaseAppModuleExtension) {
                commonExtension.defaultConfig.targetSdk = 34
                vectorDrawables {
                    useSupportLibrary = true
                }
            }
        }

        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
            }
        }
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
        compileOptions {
            sourceCompatibility = appJavaVersion
            targetCompatibility = appJavaVersion
        }

        tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = appJavaVersion.toString()
            }
        }

        buildFeatures.buildConfig = false
    }
}