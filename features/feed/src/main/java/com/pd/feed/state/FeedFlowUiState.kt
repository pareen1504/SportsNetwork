package com.pd.feed.state

import androidx.compose.runtime.Stable
import com.pd.feed.data.FeedData

sealed interface FeedFlowUiState {

    @Stable
    data class ShowFeed(val feedList: List<FeedData>? = null) : FeedFlowUiState
    object Error : FeedFlowUiState
    object Loading : FeedFlowUiState
    object Idle : FeedFlowUiState
}
