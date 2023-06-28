package com.pd.data.di

import com.pd.data.repository.FeedRepositoryImpl
import com.pd.domain.repository.FeedRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FeedRepositoryModule{

    @Binds
    internal abstract fun bindFeedRepository(feedRepositoryImpl: FeedRepositoryImpl): FeedRepository
}