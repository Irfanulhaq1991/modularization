import org.gradle.api.Plugin
import org.gradle.api.Project

internal class AndroidApplicationConvention : Plugin<Project> {
    override fun apply(target: Project) {
        target.configure(ModuleType.APP)
    }
}
