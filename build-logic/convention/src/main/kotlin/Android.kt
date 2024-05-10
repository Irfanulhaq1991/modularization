import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("UnstableApiUsage")
 fun Project.configureAndroid(commonExtension: CommonExtension<*, *, *, *, *>) {

    val appJavaVersion = JavaVersion.VERSION_1_8
    commonExtension.apply {
        compileSdk = 34

        defaultConfig.minSdk = 21
        defaultConfig {
            version = 1
            minSdk = 21
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

            if (commonExtension is BaseAppModuleExtension) {
                commonExtension.defaultConfig{
                    targetSdk = 34
                    versionCode = 1
                    versionName = "1.0"
                }

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

        buildFeatures {
            dataBinding.enable = true
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