package com.pd.feed.feed

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pd.common.network.tracker.NetworkMonitor
import com.pd.domain.entity.SportsType
import com.pd.domain.usecase.FeedUseCase
import com.pd.feed.data.FeedData
import com.pd.feed.state.FeedFlowUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

private const val DELAY = 500L
private const val STOP_TIMEOUT_MILLIS = 5_000L

@HiltViewModel
class FeedViewModel @Inject constructor(
    networkMonitor: NetworkMonitor,
    private val feedUseCase: FeedUseCase
) : ViewModel() {
    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()
    private val _feedFlowUiState = MutableStateFlow<FeedFlowUiState>(FeedFlowUiState.Idle)
    val feedFlowUiState get() = _feedFlowUiState.asStateFlow()

    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS),
            initialValue = false,
        )

    suspend fun getFeed() {
        if (isOffline.value) {
            _feedFlowUiState.value = FeedFlowUiState.Idle
            return
        }
        updateIsRefreshing(true)
        delay(DELAY)
        feedUseCase.execute().onSuccess {
            if (it.feedUiList.isNullOrEmpty()) {
                showFeedError()
                return
            }
            updateIsRefreshing(false)
            _feedFlowUiState.value = FeedFlowUiState.ShowFeed(
                it.feedUiList?.map { data ->
                    FeedData(
                        type = data.type,
                        sportsType = data.sportsType,
                        seconds = data.seconds,
                        numberOfSets = data.numberOfSets,
                        gameNumber = data.gameNumber,
                        mvp = data.mvp,
                        publicationDate = data.publicationDate,
                        tournament = data.tournament,
                        winner = data.winner,
                        looser = data.looser,
                    ).run {
                        this.copy(
                            label = feedDataToString(this)
                        )
                    }
                }
            )
        }.onFailure {
            showFeedError()
        }
    }

    private fun showFeedError() {
        updateIsRefreshing(false)
        _feedFlowUiState.value = FeedFlowUiState.Error
        Log.e("FeedViewModel", "feedUseCase api failure")
    }

    private fun feedDataToString(feed: FeedData): String? {
        return when (feed.type) {
            SportsType.F1.type ->
                "${feed.winner} wins ${feed.tournament} by ${feed.seconds} seconds"

            SportsType.NBA.type ->
                "${feed.mvp} leads ${feed.winner} to game ${feed.gameNumber} win in the ${feed.tournament}"

            SportsType.Tennis.type ->
                "${feed.tournament}: ${feed.winner} wins against ${feed.looser} in ${feed.numberOfSets} sets"

            else -> null
        }
    }

    fun updateUiState(state: FeedFlowUiState) {
        _feedFlowUiState.value = state
    }

    private fun updateIsRefreshing(isRefreshing: Boolean) {
        _isRefreshing.value = isRefreshing
    }
}
