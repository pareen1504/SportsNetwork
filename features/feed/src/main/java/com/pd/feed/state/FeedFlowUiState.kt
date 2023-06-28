package com.pd.feed.state

import com.pd.feed.data.FeedData

sealed interface FeedFlowUiState {
    data class ShowFeed(val feedList: List<FeedData>? = null) : FeedFlowUiState
    object Error : FeedFlowUiState
    object Loading : FeedFlowUiState
    object Idle : FeedFlowUiState
}