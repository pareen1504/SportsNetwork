package com.pd.data.mapper

import com.pd.data.dto.FeedResponseDTO
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class FeedResponseMapperTest {
    private val dto = mockk<FeedResponseDTO>()

    @Test
    fun testData() {
        val publicationDateF1 = "May 9, 2020 8:09:03 PM"
        val publicationDateNBA = "May 9, 2020 9:15:15 AM"
        val publicationDateTennis = "May 9, 2020 11:15:15 PM"
        every { dto.f1Results?.get(any())?.publicationDate } returns publicationDateF1
        every { dto.nbaResults?.get(any())?.publicationDate } returns publicationDateNBA
        every { dto.tennis?.get(any())?.publicationDate } returns publicationDateTennis

        val mappedF1PublicationDate: String? = with(dto) {
            f1Results?.get(0)?.publicationDate
        }
        val mappedNBAPublicationDate = with(dto) {
            nbaResults?.get(0)?.publicationDate
        }
        val mappedTennisPublicationDate = with(dto) {
            tennis?.get(0)?.publicationDate
        }

        mappedF1PublicationDate shouldBe publicationDateF1
        mappedNBAPublicationDate shouldBe publicationDateNBA
        mappedTennisPublicationDate shouldBe publicationDateTennis
    }
}