package com.pd.domain.mapper

import com.pd.common.mapper.Mapper
import com.pd.domain.entity.FeedResponse
import com.pd.domain.entity.FeedUiData
import com.pd.domain.entity.SportsType
import com.pd.domain.usecase.DateUseCase

class FeedResponseToFeedUiMapper(private val dateUseCase: DateUseCase) :
    Mapper<FeedResponse, List<FeedUiData>> {
    override suspend fun map(input: FeedResponse): List<FeedUiData> {
        val feeList = mutableListOf<FeedUiData>()
        input.tennis?.map { tennisItemDto ->
            dateUseCase.execute(tennisItemDto.publicationDate)?.let {
                feeList.add(
                    FeedUiData(
                        type = SportsType.Tennis.type,
                        sportsType = SportsType.Tennis.sportType,
                        numberOfSets = tennisItemDto.numberOfSets,
                        winner = tennisItemDto.winner,
                        tournament = tennisItemDto.tournament,
                        publicationDate = it.first,
                        publicationTime = it.second,
                        looser = tennisItemDto.looser,
                    )
                )
            }
        }

        input.f1Results?.map { f1ResultsItemDto ->
            dateUseCase.execute(f1ResultsItemDto.publicationDate)?.let {
                feeList.add(
                    FeedUiData(
                        type = SportsType.F1.type,
                        sportsType = SportsType.F1.sportType,
                        seconds = f1ResultsItemDto.seconds,
                        winner = f1ResultsItemDto.winner,
                        tournament = f1ResultsItemDto.tournament,
                        publicationDate = it.first,
                        publicationTime = it.second,
                    )
                )
            }
        }

        input.nbaResults?.map { nbaResultsItemDto ->
            dateUseCase.execute(nbaResultsItemDto.publicationDate)?.let {
                feeList.add(
                    FeedUiData(
                        type = SportsType.NBA.type,
                        sportsType = SportsType.NBA.sportType,
                        winner = nbaResultsItemDto.winner,
                        gameNumber = nbaResultsItemDto.gameNumber,
                        mvp = nbaResultsItemDto.mvp,
                        tournament = nbaResultsItemDto.tournament,
                        publicationDate = it.first,
                        publicationTime = it.second,
                        looser = nbaResultsItemDto.looser,
                    )
                )
            }
        }

        return feeList
    }
}