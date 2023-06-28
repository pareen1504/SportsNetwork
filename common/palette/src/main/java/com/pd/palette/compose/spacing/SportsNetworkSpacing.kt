package com.pd.palette.compose.spacing

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class SportsNetworkSpacing(
    val extraSmall: Dp,
    val small: Dp,
    val medium: Dp,
    val large: Dp,
    val extraLarge: Dp,
    val feedItemContentPadding: Dp,
    val feedItemContentMargin: Dp,
    val feedItemContentVerticalMargin: Dp,
)

val TundoraSpacing = SportsNetworkSpacing(
    extraSmall = 4.dp,
    small = 8.dp,
    medium = 16.dp,
    large = 32.dp,
    extraLarge = 64.dp,
    feedItemContentPadding = 14.dp,
    feedItemContentMargin = 12.dp,
    feedItemContentVerticalMargin = 7.dp,
)
