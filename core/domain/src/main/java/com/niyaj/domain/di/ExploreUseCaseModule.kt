package com.niyaj.domain.di

import com.niyaj.common.utils.CustomDispatchers
import com.niyaj.common.utils.Dispatcher
import com.niyaj.data.repository.ExploreRepository
import com.niyaj.domain.use_cases.ProfileUseCases
import com.niyaj.domain.use_cases.GetBusinessProfiles
import com.niyaj.domain.use_cases.GetCurrentUser
import com.niyaj.domain.use_cases.GetMerchantProfiles
import com.niyaj.domain.use_cases.GetPersonalProfiles
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
object ExploreUseCaseModule {

    @Provides
    fun provideExploreUseCases(
        exploreRepository: ExploreRepository,
        @Dispatcher(CustomDispatchers.IO)
        ioDispatcher: CoroutineDispatcher
    ): ProfileUseCases {
        return ProfileUseCases(
            getCurrentUser = GetCurrentUser(exploreRepository),
            getPersonalProfiles = GetPersonalProfiles(exploreRepository, ioDispatcher),
            getBusinessProfiles = GetBusinessProfiles(exploreRepository, ioDispatcher),
            getMerchantProfiles = GetMerchantProfiles(exploreRepository, ioDispatcher)
        )
    }
}