package com.niyaj.data.repository

import com.niyaj.model.BusinessProfile
import com.niyaj.model.MerchantProfile
import com.niyaj.model.PersonalProfile
import kotlinx.coroutines.flow.Flow

interface ExploreRepository {

    fun getCurrentUser(): PersonalProfile

    fun getPersonalProfiles(): Flow<List<PersonalProfile>>

    fun getBusinessProfiles(): Flow<List<BusinessProfile>>

    fun getMerchantProfiles(): Flow<List<MerchantProfile>>

}