package com.niyaj.netclan

import androidx.lifecycle.ViewModel
import com.niyaj.model.AppConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
//    userDataRepository: UserDataRepository,
) : ViewModel() {
    private val _uiState =
        MutableStateFlow<MainActivityUiState>(MainActivityUiState.Success(AppConfig()))
    val uiState = _uiState.asStateFlow()
}

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val appConfig: AppConfig) : MainActivityUiState
}
