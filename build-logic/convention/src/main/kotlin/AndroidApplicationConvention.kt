import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.irfan.build_logic.convention.extentions.configureAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationConvention:Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
           with(plugins){
               apply("com.android.application")
               apply("org.jetbrains.kotlin.android")
               apply("org.jetbrains.kotlin.kapt")
           }

            extensions.configure<BaseAppModuleExtension>{
                configureAndroid(this)
            }

            val libs =  extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                add("implementation",libs.findLibrary("core.ktx").get())
                add("implementation",libs.findLibrary("lifecycle.runtime.ktx").get())
                add("implementation",libs.findLibrary("appcompat").get())
            }

        }
    }
}


//testImplementation("junit:junit:4.13.2")
//androidTestImplementation("androidx.test.ext:junit:1.1.5")
//androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
