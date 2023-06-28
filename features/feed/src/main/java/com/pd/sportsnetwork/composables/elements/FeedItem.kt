package com.pd.sportsnetwork.composables.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pd.palette.compose.SportsNetworkTheme
import com.pd.sportsnetwork.data.FeedData

@Composable
fun FeedItem(item: FeedData) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 4.dp)
            .background(
                color = SportsNetworkTheme.colors.backgroundTertiary,
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.TopStart
    ) {
        Text(
            modifier = Modifier.padding(all = 8.dp),
            text = item.label ?: item.sportsType,
            style = SportsNetworkTheme.typography.SubtitleS2.copy(
                textAlign = TextAlign.Start
            )
        )
    }
}