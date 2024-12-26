package com.niyaj.common.utils

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val dispatcher: CustomDispatchers)

enum class CustomDispatchers {
    Default,
    IO,
}
