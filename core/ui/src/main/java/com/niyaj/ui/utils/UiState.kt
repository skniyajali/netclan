package com.niyaj.ui.utils

sealed interface UiState<out T> {
    data object Loading : UiState<Nothing>

    data object Empty : UiState<Nothing>

    data class Success<T>(val data: T) : UiState<T>
}