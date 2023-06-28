package com.pd.sportsnetwork.network.creator

import com.squareup.moshi.Moshi

interface ApiServiceCreator {
    fun <T> create(
        serviceClass: Class<T>,
        baseUrlOverride: String? = null,
        moshiOverride: Moshi.Builder? = null
    ): T
}