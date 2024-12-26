package com.niyaj.feature.refine

import android.util.Log
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.niyaj.domain.use_cases.ProfileUseCases
import com.niyaj.model.UserPurpose
import com.niyaj.model.userAvailability
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RefineViewModel @Inject constructor(
    private val profileUseCases: ProfileUseCases,
) : ViewModel() {
    private val currentUser = profileUseCases.getCurrentUser()

    private val _userAvailabilities = MutableStateFlow(userAvailability)
    val userAvailabilities = _userAvailabilities.asStateFlow()

    private val _selectedUserAvailability = MutableStateFlow(currentUser.userAvailability)
    val selectedUserAvailability = _selectedUserAvailability.asStateFlow()

    private val _userStatus = mutableStateOf(currentUser.userStatus)
    val userStatus = _userStatus.value

    private val _hyperDistance = mutableFloatStateOf(currentUser.hyperLocalDistance)
    val hyperDistance = _hyperDistance.floatValue

    private val _selectedPurpose = mutableStateListOf<UserPurpose>()
    val selectedPurpose: SnapshotStateList<UserPurpose> = _selectedPurpose


    init {
        currentUser.userPurpose.map {
            Log.d("RefineScreen", "purpose ${it.name}")
            _selectedPurpose.add(it)
        }
    }

    fun onEvent(event: RefineEvent) {
        when (event) {
            is RefineEvent.OnSelectUseAvailability -> {
                _selectedUserAvailability.value = event.status
            }

            is RefineEvent.OnChangeStatus -> {
                _userStatus.value = event.status
            }

            is RefineEvent.OnChangeHyperDistance -> {
                _hyperDistance.floatValue = event.distance
            }

            is RefineEvent.OnSelectUserPurpose -> {
                if (_selectedPurpose.contains(event.purpose)) {
                    _selectedPurpose.remove(event.purpose)
                } else {
                    _selectedPurpose.add(event.purpose)
                }
            }

            is RefineEvent.OnClickSave -> {}
        }
    }

}