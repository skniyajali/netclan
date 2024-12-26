package com.niyaj.ui.components.customFab

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

val fabOptionColor = Color(0xfff1c14d)
//val fabOptionTintColor = Color(0xFF0E2E43)

@Immutable
interface FabOption {
    @Stable
    val backgroundTint: Color

    @Stable
    val iconTint: Color

    @Stable
    val showLabel: Boolean

    @Stable
    val shape: Shape
}

private class FabOptionImpl(
    override val backgroundTint: Color,
    override val iconTint: Color,
    override val showLabel: Boolean,
    override val shape: Shape
) : FabOption

@SuppressLint("ComposableNaming")
@Composable
fun FabOption(
    backgroundTint: Color = fabOptionColor,
    iconTint: Color = MaterialTheme.colors.secondary,
    showLabel: Boolean = true,
    shape: Shape = CircleShape
): FabOption = FabOptionImpl(backgroundTint, iconTint, showLabel, shape)

