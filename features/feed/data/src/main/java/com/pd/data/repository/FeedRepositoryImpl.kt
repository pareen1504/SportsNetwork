package com.pd.data.repository

import com.pd.data.api.FeedApiService
import com.pd.data.mapper.FeedMapper
import com.pd.domain.entity.FeedResponse
import com.pd.domain.repository.FeedRepository
import com.pd.sportsnetwork.network.response.map
import com.pd.sportsnetwork.network.response.toResult
import javax.inject.Inject

internal class FeedRepositoryImpl @Inject constructor(
    private val feedApiService: FeedApiService
) : FeedRepository {
    override suspend fun getLatestFeed(): Result<FeedResponse> {
        val feedResponse = feedApiService.getLatestFeed()
        return feedResponse.map { FeedMapper.map(it) }.toResult()
    }
}