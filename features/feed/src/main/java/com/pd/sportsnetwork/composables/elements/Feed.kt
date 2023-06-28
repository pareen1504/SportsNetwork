package com.pd.sportsnetwork.composables.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pd.palette.R
import com.pd.palette.compose.SportsNetworkTheme
import com.pd.sportsnetwork.state.FeedFlowUiState

@Composable
fun Feed(
    viewState: FeedFlowUiState.ShowFeed
) {
    val listState = rememberLazyListState()
    when {
        viewState.feedList.isNullOrEmpty() -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.feed_error),
                style = SportsNetworkTheme.typography.SubtitleS2.copy(
                    textAlign = TextAlign.Center
                )
            )
        }

        else -> Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 12.dp)
                .background(
                    color = SportsNetworkTheme.colors.backgroundPrimary,
                    shape = RoundedCornerShape(12.dp)
                )
                .clip(RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.TopStart
        ) {
            LazyColumn(
                modifier = Modifier.testTag("vendors_list"),
                state = listState,
                verticalArrangement = Arrangement.Center
            ) {
                itemsIndexed(items = viewState.feedList) { index, item ->
                    if (item.label.isNullOrEmpty().not()) {
                        FeedItem(item)
                    }
                }
            }
        }
    }
}