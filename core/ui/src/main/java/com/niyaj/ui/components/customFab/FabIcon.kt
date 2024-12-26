package com.niyaj.ui.components.customFab

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
interface FabIcon {
    @Stable
    val icon: ImageVector

    @Stable
    val iconRes: Int?

    @Stable
    val iconRotate: Float?
}

private class FabIconImpl(
    override val icon: ImageVector,
    override val iconRes: Int?,
    override val iconRotate: Float?,
) : FabIcon

fun FabIcon(
    icon: ImageVector,
    @DrawableRes iconRes: Int? = null,
    iconRotate: Float? = null
): FabIcon = FabIconImpl(icon, iconRes, iconRotate)