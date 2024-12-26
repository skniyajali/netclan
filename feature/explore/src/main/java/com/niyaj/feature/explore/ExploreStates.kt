package com.niyaj.feature.explore

import com.niyaj.model.BusinessProfile
import com.niyaj.model.MerchantProfile
import com.niyaj.model.PersonalProfile

data class PersonalProfileState(
    val data: List<PersonalProfile> = emptyList(),
    val isLoading: Boolean = true,
)

data class BusinessProfileState(
    val data: List<BusinessProfile> = emptyList(),
    val isLoading: Boolean = true,
)

data class MerchantProfileState(
    val data: List<MerchantProfile> = emptyList(),
    val isLoading: Boolean = true,
)