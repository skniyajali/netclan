package com.niyaj.domain.use_cases

import com.niyaj.common.utils.CustomDispatchers
import com.niyaj.common.utils.Dispatcher
import com.niyaj.data.repository.ExploreRepository
import com.niyaj.model.BusinessProfile
import com.niyaj.model.searchProfile
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBusinessProfiles @Inject constructor(
    private val exploreRepository: ExploreRepository,
    @Dispatcher(CustomDispatchers.IO)
    private val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(searchText: String): Flow<List<BusinessProfile>> {
        return withContext(ioDispatcher) {
            exploreRepository.getBusinessProfiles().mapLatest {
                it.searchProfile(searchText)
            }
        }
    }
}