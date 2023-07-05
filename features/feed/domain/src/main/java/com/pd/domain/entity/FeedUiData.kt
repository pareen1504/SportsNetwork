package com.pd.domain.entity

data class FeedUiData(
    val type: Int? = null,
    val sportsType: String,
    val seconds: Double? = null,
    val numberOfSets: Int? = null,
    val gameNumber: Int? = null,
    val mvp: String? = null,
    val publicationDate: String? = null,
    val publicationTime: Long? = null,
    val tournament: String? = null,
    val winner: String? = null,
    val looser: String? = null
)
