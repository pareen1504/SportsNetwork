package com.pd.domain.usecase.impl

import com.pd.domain.usecase.DateUseCase
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

/*
This is very concrete implementation, if the BE changes date format this can cause crash.
Instead we should always deal with epoch time as that give flexibility to do multiple things.
*/

private val parseDateFormatter = SimpleDateFormat("MMM dd, yyyy HH:mm:ss aa", Locale.ENGLISH)
private val simpleDateFormat = SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH)

internal class DateUseCaseImpl @Inject constructor() : DateUseCase {
    override suspend fun execute(input: String): Pair<String, Long>? {
        val date = try {
            parseDateFormatter.parse(input)
        } catch (e: Exception) {
            null
        }
        return date?.let { Pair(simpleDateFormat.format(date), it.time) }
    }
}