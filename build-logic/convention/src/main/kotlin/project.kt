import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

fun Project.configure(moduleType: ModuleType, action: Project.() -> Unit = {}) =
    action().also {
        with(plugins) {
            apply("com.android.${moduleType.moduleName}")
            apply("org.jetbrains.kotlin.android")
            apply("org.jetbrains.kotlin.kapt")
        }
        when (moduleType) {
            ModuleType.APP -> extensions.configure<BaseAppModuleExtension>(::configureAndroid)
            ModuleType.LIBRARY -> extensions.configure<LibraryExtension>(::configureAndroid)

        }

        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
        dependencies {
            add("implementation", libs.findLibrary("material").get())
            add("implementation", libs.findLibrary("core.ktx").get())
            add("implementation", libs.findLibrary("lifecycle.runtime.ktx").get())
            add("implementation", libs.findLibrary("appcompat").get())
            add("androidTestImplementation", libs.findLibrary("androidx.test.ext.junit").get())
            add("androidTestImplementation", libs.findLibrary("espresso.core").get())
            add("testImplementation", libs.findLibrary("junit").get())

        }

    }


enum class ModuleType(val moduleName: String) {
    APP("application"),
    LIBRARY("library")
}
