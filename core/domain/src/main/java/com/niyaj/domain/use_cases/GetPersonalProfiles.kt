package com.niyaj.domain.use_cases

import com.niyaj.common.utils.CustomDispatchers
import com.niyaj.common.utils.Dispatcher
import com.niyaj.data.repository.ExploreRepository
import com.niyaj.model.PersonalProfile
import com.niyaj.model.filterProfile
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext
import javax.inject.Inject


class GetPersonalProfiles @Inject constructor(
    private val exploreRepository: ExploreRepository,
    @Dispatcher(CustomDispatchers.IO)
    private val ioDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(searchText: String): Flow<List<PersonalProfile>> {
        return withContext(ioDispatcher) {
            exploreRepository.getPersonalProfiles().mapLatest {
                it.filterProfile(searchText)
            }
        }
    }
}