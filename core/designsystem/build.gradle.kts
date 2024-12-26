@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("niyaj.android.library")
    id("niyaj.android.library.compose")
    id("niyaj.android.library.jacoco")
}

android {
    namespace = "com.niyaj.core.designsystem"

    defaultConfig {
        testInstrumentationRunner = "com.niyaj.testing.CustomTestRunner"
    }
    lint {
        checkDependencies = true
    }
}

dependencies {
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.util)

    debugApi(libs.androidx.compose.ui.tooling)

    implementation(libs.androidx.core.ktx)

    androidTestImplementation(project(":core:testing"))
}