package com.pd.sportsnetwork

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

const val EXPECTED = 4
const val ACTUAL = 2 + 2

class ExampleUnitTest {
    @Test
    fun additionIsCorrect() {
        assertEquals(EXPECTED, ACTUAL)
    }
}
