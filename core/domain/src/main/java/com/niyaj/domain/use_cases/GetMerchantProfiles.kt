package com.niyaj.domain.use_cases

import com.niyaj.common.utils.CustomDispatchers
import com.niyaj.common.utils.Dispatcher
import com.niyaj.data.repository.ExploreRepository
import com.niyaj.model.MerchantProfile
import com.niyaj.model.searchProfiles
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMerchantProfiles @Inject constructor(
    private val exploreRepository: ExploreRepository,
    @Dispatcher(CustomDispatchers.IO)
    private val ioDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(searchText: String): Flow<List<MerchantProfile>> {
        return withContext(ioDispatcher) {
            exploreRepository.getMerchantProfiles().mapLatest {
                it.searchProfiles(searchText)
            }
        }
    }
}