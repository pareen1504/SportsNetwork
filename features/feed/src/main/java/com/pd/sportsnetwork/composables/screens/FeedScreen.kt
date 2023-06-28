package com.pd.sportsnetwork.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pd.palette.R
import com.pd.palette.compose.SportsNetworkTheme
import com.pd.sportsnetwork.composables.elements.Feed
import com.pd.sportsnetwork.composables.elements.FeedButton
import com.pd.sportsnetwork.composables.elements.LoadingWheel
import com.pd.sportsnetwork.feed.FeedViewModel
import com.pd.sportsnetwork.state.ViewStateScaffold
import kotlinx.coroutines.launch

@Composable
fun FeedScreen(viewModel: FeedViewModel) {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    val isOffline by viewModel.isOffline.collectAsStateWithLifecycle()
    val notConnectedMessage = stringResource(R.string.not_connected)
    val feedApiError = stringResource(R.string.feed_error)
    LaunchedEffect(isOffline) {
        if (isOffline) {
            snackBarHostState.showSnackbar(
                message = notConnectedMessage,
                duration = SnackbarDuration.Indefinite,
            )
        }
    }
    val state by viewModel.feedFlowUiState.collectAsStateWithLifecycle()
    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) },
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(color = SportsNetworkTheme.colors.backgroundPrimary),
            contentAlignment = Alignment.Center
        ) {
            ViewStateScaffold(
                viewState = state,
                modifier = Modifier.wrapContentSize(),
                loading = { LoadingWheel(contentDesc = "") },
                showFeed = { Feed(it) },
                failure = {
                    scope.launch {
                        snackBarHostState.showSnackbar(
                            message = feedApiError,
                            duration = SnackbarDuration.Indefinite,
                        )
                    }
                },
                idle = {
                    FeedButton(text = { R.string.get_results }) {
                        scope.launch { viewModel.getFeed() }
                    }
                }
            )
        }
    }
}