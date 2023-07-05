package com.pd.domain.usecase.impl

import com.pd.domain.usecase.DateUseCase
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class DateUseCaseImplTest {

    private lateinit var dateUseCase: DateUseCase

    @Before
    fun setUp() {
        dateUseCase = DateUseCaseImpl()
    }

    @Test
    fun `date with response date pattern`(): Unit = runBlocking {
        val givenDate = "May 9, 2020 11:15:15 PM"
        val (date, time) = dateUseCase.execute(givenDate)!!
        date.shouldBe("May 9, 2020")
        time shouldBe 1589003115000
    }

    @Test
    fun `date with other date pattern`(): Unit = runBlocking {
        val givenDate = "01/09/2020 11:15:15 PM"
        dateUseCase.execute(givenDate) shouldBe null
    }
}