import com.niyaj.samples.apps.CustomBuildType

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("niyaj.android.application")
    id("niyaj.android.application.compose")
    id("niyaj.android.application.flavors")
    id("niyaj.android.application.jacoco")
    id("jacoco")
    id("niyaj.android.hilt")
}

android {
    namespace = libs.versions.namespace.get()
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = libs.versions.namespace.get()
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
        testInstrumentationRunner = "com.niyaj.testing.CustomTestRunner"
    }

    buildTypes {
        debug {
            applicationIdSuffix = CustomBuildType.DEBUG.applicationIdSuffix
        }

        val release by getting {
            isMinifyEnabled = true
            applicationIdSuffix = CustomBuildType.RELEASE.applicationIdSuffix
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            signingConfig = signingConfigs.getByName("debug")
        }

        create("create") {
            // Enable all the optimizations from release build through initWith(release).
            initWith(release)
            matchingFallbacks.add("release")
            // Debug key signing is available to everyone.
            signingConfig = signingConfigs.getByName("debug")
            // Only use benchmark proguard rules
            proguardFiles("benchmark-rules.pro")
            isMinifyEnabled = true
            applicationIdSuffix = CustomBuildType.BENCHMARK.applicationIdSuffix
        }
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("META-INF/LICENSE.md")
            excludes.add("META-INF/LICENSE-notice.md")
            excludes.add("DebugProbesKt.bin")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {

    // App Features
    implementation(project(":feature:explore"))
    implementation(project(":feature:refine"))

    // Core resources
    implementation(project(":core:common"))
    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.accompanist.permissions)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.window.manager)
    implementation(libs.androidx.compose.material3.windowSizeClass)

    implementation(libs.androidx.profileinstaller)
    implementation(libs.kotlinx.coroutines.guava)

    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.core.startup)

    // Timber
    implementation(libs.timber)

    androidTestImplementation(project(":core:testing"))
    androidTestImplementation(libs.androidx.navigation.testing)
    androidTestImplementation(kotlin("test"))
    debugImplementation(libs.androidx.compose.ui.testManifest)

}