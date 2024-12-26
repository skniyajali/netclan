package com.niyaj.feature.explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niyaj.domain.use_cases.ProfileUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val profileUseCases: ProfileUseCases,
) : ViewModel() {

    private val _personalSearch = MutableStateFlow("")
    val personalSearch = _personalSearch.asStateFlow()

    private val _businessSearch = MutableStateFlow("")
    val businessSearch = _businessSearch.asStateFlow()

    private val _merchantSearch = MutableStateFlow("")
    val merchantSearch = _merchantSearch.asStateFlow()

    val currentUser = profileUseCases.getCurrentUser()

    private val _personalProfiles = MutableStateFlow(PersonalProfileState())
    val personalProfiles = _personalProfiles.asStateFlow()

    private val _businessProfiles = MutableStateFlow(BusinessProfileState())
    val businessProfiles = _businessProfiles.asStateFlow()

    private val _merchantProfiles = MutableStateFlow(MerchantProfileState())
    val merchantProfiles = _merchantProfiles.asStateFlow()


    init {
        getPersonalProfiles()
        getBusinessProfiles()
        getMerchantProfiles()
    }

    fun onEvent(event: ExploreEvent) {
        when (event) {
            is ExploreEvent.OnPersonalSearch -> {
                _personalSearch.value = event.searchText

                getPersonalProfiles(event.searchText)
            }

            is ExploreEvent.OnClearPersonalSearch -> {
                _personalSearch.value = ""
                getPersonalProfiles()
            }


            is ExploreEvent.OnBusinessSearch -> {
                _businessSearch.value = event.searchText
                getBusinessProfiles(event.searchText)
            }

            is ExploreEvent.OnClearBusinessSearch -> {
                _businessSearch.value = ""
                getBusinessProfiles()
            }


            is ExploreEvent.OnMerchantSearch -> {
                _merchantSearch.value = event.searchText
                getMerchantProfiles(event.searchText)
            }

            is ExploreEvent.OnClearMerchantSearch -> {
                _merchantSearch.value = ""
                getMerchantProfiles()
            }

            is ExploreEvent.OnRefreshPersonalProfile -> {
                _personalSearch.value = ""
                getPersonalProfiles()
            }

            is ExploreEvent.OnRefreshBusinessProfile -> {
                _businessSearch.value = ""

                getBusinessProfiles()
            }

            is ExploreEvent.OnRefreshMerchantProfile -> {
                _merchantSearch.value = ""
                getMerchantProfiles()
            }
        }
    }

    private fun getPersonalProfiles(searchText: String = "") {
        viewModelScope.launch {
            profileUseCases.getPersonalProfiles(searchText).collectLatest {
                _personalProfiles.value = _personalProfiles.value.copy(
                    data = it,
                    isLoading = false,
                )
            }
        }
    }

    private fun getBusinessProfiles(searchText: String = "") {
        viewModelScope.launch {
            profileUseCases.getBusinessProfiles(searchText).collectLatest {
                _businessProfiles.value = _businessProfiles.value.copy(
                    data = it,
                    isLoading = false,
                )
            }
        }
    }

    private fun getMerchantProfiles(searchText: String = "") {
        viewModelScope.launch {
            profileUseCases.getMerchantProfiles(searchText).collectLatest {
                _merchantProfiles.value = _merchantProfiles.value.copy(
                    data = it,
                    isLoading = false,
                )
            }
        }
    }
}