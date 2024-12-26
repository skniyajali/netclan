package com.niyaj.data.repository

import com.niyaj.model.BusinessProfile
import com.niyaj.model.MerchantProfile
import com.niyaj.model.PersonalProfile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExploreRepositoryImpl @Inject constructor(
    private val localData: LocalData
) : ExploreRepository {

    override fun getCurrentUser(): PersonalProfile {
        return localData.currentUser
    }

    override fun getPersonalProfiles(): Flow<List<PersonalProfile>> {
        return flow { emit(localData.personalProfiles) }
    }

    override fun getBusinessProfiles(): Flow<List<BusinessProfile>> {
        return flow { emit(localData.businessProfiles) }
    }

    override fun getMerchantProfiles(): Flow<List<MerchantProfile>> {
        return flow { emit(localData.merchantProfiles) }
    }
}