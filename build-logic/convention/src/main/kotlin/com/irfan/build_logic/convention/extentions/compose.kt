package com.irfan.build_logic.convention.extentions

import org.gradle.api.Project
import com.android.build.gradle.BaseExtension
import org.gradle.api.artifacts.VersionCatalog

@Suppress("UnstableApiUsage")
internal fun Project.configureCompose(commonExtension: BaseExtension, libs: VersionCatalog) {
    commonExtension.apply {

        buildFeatures.apply {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("compose.compiler").get().toString()
        }
    }

}