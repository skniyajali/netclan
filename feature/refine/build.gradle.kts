@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("niyaj.android.feature")
    id("niyaj.android.library.compose")
    id("niyaj.android.library.jacoco")
    id("niyaj.android.hilt")
}

android {
    namespace = "com.niyaj.feature.refine"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}