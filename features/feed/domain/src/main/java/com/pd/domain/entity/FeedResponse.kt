package com.pd.domain.entity

data class FeedResponse(
    val tennis: List<TennisItem>?,
    val f1Results: List<F1ResultsItem>?,
    val nbaResults: List<NbaResultsItem>?
) {
    data class F1ResultsItem(
        val seconds: Double = 0.0,
        val winner: String = "",
        val tournament: String = "",
        val publicationDate: String = ""
    )

    data class NbaResultsItem(
        val winner: String = "",
        val gameNumber: Int = 0,
        val mvp: String = "",
        val tournament: String = "",
        val publicationDate: String = "",
        val looser: String = ""
    )

    data class TennisItem(
        val numberOfSets: Int = 0,
        val winner: String = "",
        val tournament: String = "",
        val publicationDate: String = "",
        val looser: String = ""
    )


}

