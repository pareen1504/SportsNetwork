package com.pd.feed.di

import com.pd.domain.di.FeedUseCaseModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module(includes = [FeedUseCaseModule::class])
@InstallIn(SingletonComponent::class)
internal object FeedScreenModule