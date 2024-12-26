package com.niyaj.domain.use_cases

data class ProfileUseCases(
    val getCurrentUser: GetCurrentUser,
    val getPersonalProfiles: GetPersonalProfiles,
    val getBusinessProfiles: GetBusinessProfiles,
    val getMerchantProfiles: GetMerchantProfiles,
)
