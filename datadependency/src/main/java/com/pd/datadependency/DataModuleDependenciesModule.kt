package com.pd.datadependency

import com.pd.data.di.FeedDataModule
import com.pd.data.di.FeedRepositoryModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module(includes = [FeedDataModule::class,FeedRepositoryModule::class])
@InstallIn(SingletonComponent::class)
object SingletonDataDependencies