
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("niyaj.android.library")
    id("niyaj.android.library.jacoco")
    id("niyaj.android.hilt")
}

android {
    namespace = "com.niyaj.core.domain"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))
    implementation(project(":core:common"))

    implementation(libs.hilt.android)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)

    testImplementation(project(":core:testing"))
}