plugins {
    id("niyaj.android.library")
    id("niyaj.android.library.jacoco")
    id("niyaj.android.hilt")
}

android {
    namespace = "com.niyaj.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    testImplementation(project(":core:testing"))
}