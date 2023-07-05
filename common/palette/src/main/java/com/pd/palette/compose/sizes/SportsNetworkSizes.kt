package com.pd.palette.compose.sizes

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class SportsNetworkSizes(
    val iconDefaultSize: Dp,
    val justificationHeaderIconSize: Dp,
    val sportsnetworkCardContentTextSize: TextUnit,
    val cardContentTextHintSize: TextUnit,
    val sportsnetworkCardUserCellItemTextSize: TextUnit,
    val sportsnetworkCardHandleTextSize: TextUnit,
    val sportsnetworkCardRoundCornersSize: Dp
)

val TundoraSizes = SportsNetworkSizes(
    iconDefaultSize = 24.dp,
    justificationHeaderIconSize = 16.dp,
    sportsnetworkCardContentTextSize = 15.sp,
    cardContentTextHintSize = 14.sp,
    sportsnetworkCardUserCellItemTextSize = 12.sp,
    sportsnetworkCardHandleTextSize = 14.sp,
    sportsnetworkCardRoundCornersSize = 10.dp
)
