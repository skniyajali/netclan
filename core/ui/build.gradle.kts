@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("niyaj.android.library")
    id("niyaj.android.library.compose")
    id("niyaj.android.library.jacoco")
}

android {
    namespace = "com.niyaj.core.ui"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
//    api(libs.androidx.compose.foundation)
//    api(libs.androidx.compose.foundation.layout)
//    api(libs.androidx.compose.material.iconsExtended)
//    api(libs.androidx.compose.material)
//    api(libs.androidx.compose.runtime)
//    api(libs.androidx.compose.runtime.livedata)
//    api(libs.androidx.compose.ui.tooling.preview)
//    api(libs.androidx.compose.ui.util)
    
    api(libs.androidx.metrics)
    api(libs.androidx.tracing.ktx)

    api(libs.androidx.hilt.navigation.compose)
    api(libs.androidx.navigation.compose)

    debugApi(libs.androidx.compose.ui.tooling)

    implementation(project(":core:designsystem"))
    implementation(project(":core:domain"))
    implementation(project(":core:model"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.datetime)

    androidTestImplementation(project(":core:testing"))
}