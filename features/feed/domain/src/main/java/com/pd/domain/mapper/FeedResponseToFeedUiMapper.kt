package com.pd.domain.mapper

import com.pd.common.mapper.Mapper
import com.pd.domain.entity.FeedResponse
import com.pd.domain.entity.FeedUiData
import com.pd.domain.entity.SportsType

object FeedResponseToFeedUiMapper : Mapper<FeedResponse, List<FeedUiData>> {
    override suspend fun map(input: FeedResponse): List<FeedUiData> {
        val feeList = mutableListOf<FeedUiData>()
        input.tennis?.firstOrNull { tennisItemDto ->
            addToFeed(
                feeList = feeList,
                type = SportsType.Tennis.type,
                sportsType = SportsType.Tennis.sportType,
                numberOfSets = tennisItemDto.numberOfSets,
                winner = tennisItemDto.winner,
                tournament = tennisItemDto.tournament,
                publicationDate = tennisItemDto.publicationDate,
                looser = tennisItemDto.looser,
            )
        }
        input.f1Results?.firstOrNull { f1ResultsItemDto ->
            addToFeed(
                feeList = feeList,
                type = SportsType.F1.type,
                sportsType = SportsType.F1.sportType,
                seconds = f1ResultsItemDto.seconds,
                winner = f1ResultsItemDto.winner,
                tournament = f1ResultsItemDto.tournament,
                publicationDate = f1ResultsItemDto.publicationDate
            )
        }

        input.nbaResults?.firstOrNull { nbaResultsItemDto ->
            addToFeed(
                feeList = feeList,
                type = SportsType.NBA.type,
                sportsType = SportsType.NBA.sportType,
                winner = nbaResultsItemDto.winner,
                gameNumber = nbaResultsItemDto.gameNumber,
                mvp = nbaResultsItemDto.mvp,
                tournament = nbaResultsItemDto.tournament,
                publicationDate = nbaResultsItemDto.publicationDate,
                looser = nbaResultsItemDto.looser,
            )
        }

        return feeList
    }

    private fun addToFeed(
        feeList: MutableList<FeedUiData>,
        type: Int? = null,
        sportsType: String,
        seconds: Double? = null,
        numberOfSets: Int? = null,
        gameNumber: Int? = null,
        mvp: String? = null,
        publicationDate: String? = null,
        tournament: String? = null,
        winner: String? = null,
        looser: String? = null
    ) = feeList.add(
        FeedUiData(
            type = type,
            sportsType = sportsType,
            winner = winner,
            seconds = seconds,
            numberOfSets = numberOfSets,
            gameNumber = gameNumber,
            mvp = mvp,
            tournament = tournament,
            publicationDate = publicationDate,
            looser = looser,
        )
    )
}