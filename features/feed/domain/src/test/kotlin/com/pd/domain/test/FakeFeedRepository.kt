package com.pd.domain.test

import com.pd.domain.entity.FeedResponse
import com.pd.domain.repository.FeedRepository

class FakeFeedRepository : FeedRepository {

    private val tennis = mutableListOf<FeedResponse.TennisItem>()
    private val f1Results = mutableListOf<FeedResponse.F1ResultsItem>()
    private val nbaResults = mutableListOf<FeedResponse.NbaResultsItem>()

    init {
        tennis.addAll(
            listOf(
                FeedResponse.TennisItem(
                    looser = "Schwartzman ",
                    numberOfSets = 3,
                    publicationDate = "May 9, 2020 11:15:15 PM",
                    tournament = "Roland Garros",
                    winner = "Rafael Nadal"
                ), FeedResponse.TennisItem(
                    looser = "Stefanos Tsitsipas ",
                    numberOfSets = 3,
                    publicationDate = "May 9, 2020 2:00:40 PM",
                    tournament = "Roland Garros",
                    winner = "Novak Djokovic"
                )
            )
        )

        nbaResults.addAll(
            listOf(
                FeedResponse.NbaResultsItem(
                    gameNumber = 6,
                    looser = "Heat",
                    mvp = "Lebron James",
                    publicationDate = "May 9, 2020 9:15:15 AM",
                    tournament = "NBA playoffs",
                    winner = "Lakers"
                ), FeedResponse.NbaResultsItem(
                    gameNumber = 5,
                    looser = "Lakers",
                    mvp = "Jimmy Butler",
                    publicationDate = "May 7, 2020 3:15:00 PM",
                    tournament = "NBA playoffs",
                    winner = "Heat"
                )
            )
        )

        f1Results.addAll(
            listOf(
                FeedResponse.F1ResultsItem(
                    publicationDate = "May 9, 2020 8:09:03 PM",
                    seconds = 5.856,
                    tournament = "Silverstone Grand Prix",
                    winner = "Lewis Hamilton"
                ),
                FeedResponse.F1ResultsItem(
                    publicationDate = "Mar 15, 2020 8:09:03 PM",
                    seconds = 5.856,
                    tournament = "Spa BELGIAN GRAND PRIX",
                    winner = "Lewis Hamilton"
                )
            ),
        )
    }

    override suspend fun getLatestFeed(): Result<FeedResponse> {
        return Result.success(
            FeedResponse(
                tennis = tennis,
                f1Results = f1Results,
                nbaResults = nbaResults
            )
        )
    }
}