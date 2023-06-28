package com.pd.data.mapper

import com.pd.common.mapper.Mapper
import com.pd.data.dto.FeedResponseDTO
import com.pd.domain.entity.FeedResponse

object FeedMapper : Mapper<FeedResponseDTO, FeedResponse> {
    override suspend fun map(input: FeedResponseDTO): FeedResponse {
        return FeedResponse(
            tennis = input.tennis?.map { tennisItemDto ->
                FeedResponse.TennisItem(
                    numberOfSets = tennisItemDto.numberOfSets,
                    winner = tennisItemDto.winner,
                    tournament = tennisItemDto.tournament,
                    publicationDate = tennisItemDto.publicationDate,
                    looser = tennisItemDto.looser,
                )
            },
            f1Results = input.f1Results?.map { f1ResultsItemDto ->
                FeedResponse.F1ResultsItem(
                    seconds = f1ResultsItemDto.seconds,
                    winner = f1ResultsItemDto.winner,
                    tournament = f1ResultsItemDto.tournament,
                    publicationDate = f1ResultsItemDto.publicationDate
                )
            },
            nbaResults = input.nbaResults?.map { nbaResultsItemDto ->
                FeedResponse.NbaResultsItem(
                    winner = nbaResultsItemDto.winner,
                    gameNumber = nbaResultsItemDto.gameNumber,
                    mvp = nbaResultsItemDto.mvp,
                    tournament = nbaResultsItemDto.tournament,
                    publicationDate = nbaResultsItemDto.publicationDate,
                    looser = nbaResultsItemDto.looser,
                )
            }
        )
    }
}