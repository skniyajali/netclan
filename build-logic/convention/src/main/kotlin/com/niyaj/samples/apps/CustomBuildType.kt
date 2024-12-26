
package com.niyaj.samples.apps

/**
 * This is shared between :app and :benchmarks module to provide configurations type safety.
 */
@Suppress("unused")
enum class CustomBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
    BENCHMARK(".benchmark")
}
