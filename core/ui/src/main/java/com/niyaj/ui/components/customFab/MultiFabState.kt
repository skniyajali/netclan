package com.niyaj.ui.components.customFab

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

sealed class MultiFabState {
    data object Collapsed : MultiFabState()
    data object Expand : MultiFabState()

    fun isExpanded() = this == Expand

    fun toggleValue() = if (isExpanded()) {
        Collapsed
    } else {
        Expand
    }
}

@Composable
fun rememberMultiFabState() = remember { mutableStateOf<MultiFabState>(MultiFabState.Collapsed) }