package com.pd.sportsnetwork.network.creator

import com.pd.sportsnetwork.network.adapter.JSONArrayAdapter
import com.pd.sportsnetwork.network.adapter.JSONObjectAdapter
import com.pd.sportsnetwork.network.interceptors.HeaderInformationInterceptor
import com.pd.sportsnetwork.network.response.NetworkResponseCallAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private const val BASE_URL = "https://restest.free.beeceptor.com"

internal class RetrofitServiceCreator @Inject constructor(
    headerInformationInterceptor: HeaderInformationInterceptor,
    moshi: Moshi,
) : ApiServiceCreator {
    private val okHttpClient = OkHttpClient.Builder().apply {
        connectionPool(
            ConnectionPool(
                maxIdleConnections = 5,
                keepAliveDuration = 5,
                timeUnit = TimeUnit.MINUTES
            )
        )
        addInterceptor(
            HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        )
        addInterceptor(headerInformationInterceptor)
    }.build()

    private val defaultRemoteMoshi = moshi.newBuilder()
        .add(JSONArrayAdapter)
        .add(JSONObjectAdapter).build()

    override fun <T> create(
        serviceClass: Class<T>,
        baseUrlOverride: String?,
        moshiOverride: Moshi.Builder?,
    ): T = createRetrofitBuilder(moshiOverride, baseUrlOverride).build().create(serviceClass)

    private fun createRetrofitBuilder(moshiOverride: Moshi.Builder?, baseUrlOverride: String?) =
        with(Retrofit.Builder()) {
            client(okHttpClient)
            addCallAdapterFactory(NetworkResponseCallAdapterFactory)
            addConverterFactory(MoshiConverterFactory.create(defaultRemoteMoshi))
            baseUrl(BASE_URL)
        }
}
