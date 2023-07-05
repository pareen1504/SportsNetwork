package com.pd.domain.di

import com.pd.domain.usecase.DateUseCase
import com.pd.domain.usecase.FeedUseCase
import com.pd.domain.usecase.impl.DateUseCaseImpl
import com.pd.domain.usecase.impl.FeedUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
abstract class FeedUseCaseModule {

    @Binds
    internal abstract fun bindFeedUseCase(feedUseCaseImpl: FeedUseCaseImpl): FeedUseCase
    internal abstract fun bindDateUseCase(dateUseCaseImpl: DateUseCaseImpl): DateUseCase
}