@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("niyaj.android.library")
    id("niyaj.android.library.jacoco")
    id("niyaj.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.niyaj.core.data"
    compileSdk = libs.versions.compileSdk.get().toInt()

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:database"))
    implementation(project(":core:model"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(project(":core:testing"))
}