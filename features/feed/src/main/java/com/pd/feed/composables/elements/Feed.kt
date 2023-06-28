package com.pd.feed.composables.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.pd.feed.state.FeedFlowUiState
import com.pd.palette.compose.SportsNetworkTheme

@Composable
fun Feed(viewState: FeedFlowUiState.ShowFeed) {
    val listState = rememberLazyListState()
    viewState.feedList?.let { feedList ->
        Box(
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
                modifier = Modifier.testTag("feed_list"),
                state = listState,
                verticalArrangement = Arrangement.Center
            ) {
                itemsIndexed(items = feedList, key = { index, _ -> index }) { _, item ->
                    if (item.label.isNullOrEmpty().not()) {
                        FeedItem(item)
                    }
                }
            }
        }
    }
}