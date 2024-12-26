@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("niyaj.android.library")
    id("niyaj.android.library.compose")
    id("niyaj.android.hilt")
}

android {
    namespace = "com.niyaj.core.testing"
}

dependencies {
    api(libs.androidx.compose.ui.test)
    api(libs.androidx.test.core)
    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.rules)
    api(libs.androidx.test.runner)
    api(libs.hilt.android.testing)
    api(libs.junit4)
    api(libs.kotlinx.coroutines.test)

    debugApi(libs.androidx.compose.ui.testManifest)

    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:model"))
}