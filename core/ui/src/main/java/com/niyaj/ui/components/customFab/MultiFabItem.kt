package com.niyaj.ui.components.customFab

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

data class MultiFabItem(
    val id: Int,

    val route: String,

    @DrawableRes val iconRes: Int? = null,

    val icon: ImageVector,

    val label: String = ""
)