@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("niyaj.android.library")
    id("niyaj.android.library.jacoco")
}

android {
    namespace = "com.niyaj.core.database"

    defaultConfig {
        testInstrumentationRunner = "com.niyaj.testing.CustomTestRunner"
    }
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:common"))

    implementation(libs.kotlinx.coroutines.android)

    androidTestImplementation(project(":core:testing"))
}