package com.pd.domain.repository

import com.pd.domain.entity.FeedResponse


interface FeedRepository {
    suspend fun getLatestFeed(): Result<FeedResponse>
}