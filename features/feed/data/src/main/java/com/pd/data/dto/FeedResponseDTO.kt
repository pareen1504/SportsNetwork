package com.pd.data.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class F1ResultsItemDTO(
    @Json(name = "seconds")
    val seconds: Double = 0.0,
    @Json(name = "winner")
    val winner: String = "",
    @Json(name = "tournament")
    val tournament: String = "",
    @Json(name = "publicationDate")
    val publicationDate: String = ""
)

@JsonClass(generateAdapter = true)
data class NbaResultsItemDTO(
    @Json(name = "winner")
    val winner: String = "",
    @Json(name = "gameNumber")
    val gameNumber: Int = 0,
    @Json(name = "mvp")
    val mvp: String = "",
    @Json(name = "tournament")
    val tournament: String = "",
    @Json(name = "publicationDate")
    val publicationDate: String = "",
    @Json(name = "looser")
    val looser: String = ""
)

@JsonClass(generateAdapter = true)
data class TennisItemDTO(
    @Json(name = "numberOfSets")
    val numberOfSets: Int = 0,
    @Json(name = "winner")
    val winner: String = "",
    @Json(name = "tournament")
    val tournament: String = "",
    @Json(name = "publicationDate")
    val publicationDate: String = "",
    @Json(name = "looser")
    val looser: String = ""
)

@JsonClass(generateAdapter = true)
data class FeedResponseDTO(
    @Json(name = "Tennis")
    val tennis: List<TennisItemDTO>?,
    @Json(name = "f1Results")
    val f1Results: List<F1ResultsItemDTO>?,
    @Json(name = "nbaResults")
    val nbaResults: List<NbaResultsItemDTO>?
)


