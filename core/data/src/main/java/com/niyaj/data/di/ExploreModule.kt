package com.niyaj.data.di

import com.niyaj.data.repository.ExploreRepository
import com.niyaj.data.repository.ExploreRepositoryImpl
import com.niyaj.data.repository.LocalData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object ExploreModule {

    @Provides
    fun provideLocalData(): LocalData = LocalData()

    @Provides
    fun provideExploreRepository(
        localData: LocalData
    ): ExploreRepository {
        return ExploreRepositoryImpl(localData)
    }
}