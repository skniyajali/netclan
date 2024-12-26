package com.niyaj.domain.use_cases

import com.niyaj.data.repository.ExploreRepository
import com.niyaj.model.PersonalProfile
import javax.inject.Inject

class GetCurrentUser @Inject constructor(
    private val exploreRepository: ExploreRepository
) {
    operator fun invoke(): PersonalProfile {
        return exploreRepository.getCurrentUser()
    }
}