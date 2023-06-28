package com.pd.sportsnetwork.network.di

import com.pd.sportsnetwork.network.creator.ApiServiceCreator
import com.pd.sportsnetwork.network.creator.RetrofitServiceCreator
import com.pd.sportsnetwork.network.interceptors.HeaderInformationInterceptor
import com.pd.sportsnetwork.network.interceptors.HeaderInformationInterceptorImpl
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    @Binds
    @Singleton
    internal abstract fun bindServiceCreator(retrofitServiceCreator: RetrofitServiceCreator): ApiServiceCreator

    @Binds
    @Singleton
    internal abstract fun bindHeaderInformationInterceptor(
        headerInformationInterceptor: HeaderInformationInterceptorImpl
    ): HeaderInformationInterceptor

    companion object {
        @Provides
        @Singleton
        fun provideMoshi(): Moshi = Moshi.Builder().build()
    }
}