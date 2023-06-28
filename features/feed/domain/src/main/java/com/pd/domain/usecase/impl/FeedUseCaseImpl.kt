package com.pd.domain.usecase.impl

import com.pd.domain.entity.FeedList
import com.pd.domain.mapper.FeedResponseToFeedUiMapper
import com.pd.domain.repository.FeedRepository
import com.pd.domain.usecase.FeedUseCase
import javax.inject.Inject

internal class FeedUseCaseImpl @Inject constructor(
    private val feedRepository: FeedRepository
) : FeedUseCase {
    override suspend fun execute(): Result<FeedList> {
        return feedRepository.getLatestFeed().map {
            FeedResponseToFeedUiMapper.map(it)
        }.map {
            FeedList(feedUiList = it)
        }
    }
}