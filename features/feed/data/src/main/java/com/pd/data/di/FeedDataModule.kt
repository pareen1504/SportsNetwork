package com.pd.data.di

import com.pd.data.api.FeedApiService
import com.pd.sportsnetwork.network.creator.ApiServiceCreator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FeedDataModule {

    @Singleton
    @Provides
    fun providesFeedApiService(serviceCreator: ApiServiceCreator): FeedApiService {
        return serviceCreator.create(serviceClass = FeedApiService::class.java)
    }

}