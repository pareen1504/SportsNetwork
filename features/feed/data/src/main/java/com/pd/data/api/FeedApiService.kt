package com.pd.data.api

import com.pd.data.dto.FeedResponseDTO
import com.pd.sportsnetwork.network.response.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.POST

interface FeedApiService {

    @POST(value = "/results")
    suspend fun getLatestFeed(): NetworkResponse<FeedResponseDTO>
}