pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Netclan"
include(":app")
//include(":benchmark")
include(":core:data")
include(":core:domain")
include(":core:model")
include(":core:database")
include(":core:ui")
include(":core:common")
include(":core:designsystem")
include(":core:testing")
include(":feature:explore")
include(":feature:refine")
