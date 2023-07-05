package com.pd.domain.usecase.impl

import com.pd.domain.test.FakeFeedRepository
import com.pd.domain.usecase.FeedUseCase
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class FeedUseCaseImplTest {

    private lateinit var feedRepository: FakeFeedRepository
    private val dateUseCase = DateUseCaseImpl()
    private lateinit var feedUseCase: FeedUseCase


    @Before
    fun setUp() {
        feedRepository = FakeFeedRepository()
        feedUseCase = FeedUseCaseImpl(feedRepository, dateUseCase)
    }


    @Test
    fun `verify latest feed size`(): Unit = runBlocking {
        feedUseCase.execute().map {
            it.feedUiList?.size shouldBe 4
        }
    }

    @Test
    fun `verify latest feed date`(): Unit = runBlocking {
        feedUseCase.execute().map {
            it.feedUiList?.get(0)?.publicationDate shouldBe "May 9, 2020"
        }
    }

}