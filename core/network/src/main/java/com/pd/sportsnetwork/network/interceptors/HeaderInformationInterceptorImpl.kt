package com.pd.sportsnetwork.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/* Here you can add your request headers */
class HeaderInformationInterceptorImpl @Inject constructor() : HeaderInformationInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}