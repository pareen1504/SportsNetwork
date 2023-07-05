package com.pd.domain.usecase.impl

import com.pd.domain.entity.FeedList
import com.pd.domain.entity.FeedUiData
import com.pd.domain.mapper.FeedResponseToFeedUiMapper
import com.pd.domain.repository.FeedRepository
import com.pd.domain.usecase.FeedUseCase
import javax.inject.Inject

internal class FeedUseCaseImpl @Inject constructor(
    private val feedRepository: FeedRepository,
    private val dateUseCaseImpl: DateUseCaseImpl
) : FeedUseCase {
    override suspend fun execute(): Result<FeedList> {
        return feedRepository.getLatestFeed().map {
            FeedResponseToFeedUiMapper(dateUseCaseImpl).map(it)
        }.map { output ->
            FeedList(feedUiList =
            output.sortedWith(
                compareBy<FeedUiData> { it.publicationDate }.thenBy { it.publicationTime }
            )
                .filter { feedUiList -> feedUiList.publicationDate == output[0].publicationDate })
        }
    }
}