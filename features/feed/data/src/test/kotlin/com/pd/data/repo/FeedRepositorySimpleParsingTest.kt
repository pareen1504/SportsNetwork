package com.pd.data.repo

import com.pd.data.api.FeedApiService
import com.pd.data.repository.FeedRepositoryImpl
import com.pd.domain.repository.FeedRepository
import com.pd.sportsnetwork.network.response.HttpException
import com.pd.sportsnetwork.network.response.NetworkResponseCallAdapterFactory
import com.pd.test.enqueueResponse
import com.squareup.moshi.Moshi
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException

class FeedRepositorySimpleParsingTest {
    private val mockWebServer = MockWebServer()
    private val moshi = Moshi.Builder().build()

    private val feedApiService = Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .addCallAdapterFactory(NetworkResponseCallAdapterFactory)
        .addConverterFactory(MoshiConverterFactory.create(moshi.newBuilder().build()))
        .build()
        .create(FeedApiService::class.java)

    private val feedRepository: FeedRepository = FeedRepositoryImpl(feedApiService)

    @Before
    fun setUp() {

    }

    @Test
    fun testF1Results() {
        mockWebServer.enqueueResponse("api-response/feedresponse.json", code = 200)
        val feedF1Results = runBlocking {
            requireNotNull(feedRepository.getLatestFeed())
        }.getOrThrow()
        feedF1Results.f1Results?.size shouldBe 3
    }

    @Test
    fun testNBAResults() {
        mockWebServer.enqueueResponse("api-response/feedresponse.json", code = 200)
        val feedNBAResults = runBlocking {
            requireNotNull(feedRepository.getLatestFeed())
        }.getOrThrow()
        feedNBAResults.nbaResults?.size shouldBe 5
    }

    @Test
    fun testTennisResults() {
        mockWebServer.enqueueResponse("api-response/feedresponse.json", code = 200)
        val feedTennisResults = runBlocking {
            requireNotNull(feedRepository.getLatestFeed())
        }.getOrThrow()
        feedTennisResults.tennis?.size shouldBe 3
    }

    @Test
    fun testEmptyObject() {
        mockWebServer.enqueue(MockResponse().setBody("{}").setResponseCode(200))
        val feedResult = runBlocking {
            requireNotNull(feedRepository.getLatestFeed())
        }.getOrThrow()
        feedResult.f1Results?.size shouldBe null
        feedResult.nbaResults?.size shouldBe null
        feedResult.tennis?.size shouldBe null
    }

    @Test
    fun testEmptyResponse() {
        mockWebServer.enqueue(MockResponse().setBody("").setResponseCode(200))
        val feedResult = runBlocking {
            requireNotNull(feedRepository.getLatestFeed())
        }
        feedResult.isFailure shouldBe true
        feedResult.isSuccess shouldBe false
        feedResult.exceptionOrNull() shouldNotBe null
        feedResult.exceptionOrNull()?.javaClass shouldBe IOException::class.java
    }

    @Test
    fun test500FailureResponse() {
        mockWebServer.enqueueResponse("api-response/error_response.json", code = 500)
        val feedResult = runBlocking {
            requireNotNull(feedRepository.getLatestFeed())
        }
        feedResult.isFailure shouldBe true
        feedResult.isSuccess shouldBe false
        feedResult.exceptionOrNull() shouldNotBe null
        feedResult.exceptionOrNull()?.javaClass shouldBe HttpException::class.java
        (feedResult.exceptionOrNull() as HttpException).statusCode shouldBe 500
    }

    @After
    fun deInit() {
        mockWebServer.shutdown()
    }
}