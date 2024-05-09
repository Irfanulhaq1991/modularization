import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    `kotlin-dsl`
}

group = "com.irfan.modularization.buildlogic"
val appJavaVersion = JavaVersion.VERSION_17

java {
    sourceCompatibility = appJavaVersion
    targetCompatibility = appJavaVersion
}

kotlin{
  jvmToolchain{
      languageVersion.set(JavaLanguageVersion.of(appJavaVersion.toString()))
  }
}

dependencies {
    compileOnly(libs.android.tools.build.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}


gradlePlugin{
    plugins {
        register("AndroidApplication"){
            id = "irfan.android.application"
            implementationClass = "AndroidApplicationConvention"
        }

        register("AndroidLibrary"){
            id = "irfan.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("AndroidCompose"){
            id = "irfan.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
    }
}