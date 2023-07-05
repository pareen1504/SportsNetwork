package com.pd.feed.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pd.common.R
import com.pd.common.composables.SportNetworkButton
import com.pd.common.composables.SportsNetworkTopBar
import com.pd.feed.composables.elements.Feed
import com.pd.feed.feed.FeedViewModel
import com.pd.feed.state.FeedFlowUiState
import com.pd.feed.state.ViewStateScaffold
import com.pd.palette.compose.SportsNetworkTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressWarnings("LongMethod")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FeedScreen() {
    val viewModel: FeedViewModel = hiltViewModel()
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    val refreshing by viewModel.isRefreshing.collectAsStateWithLifecycle()
    val isOffline by viewModel.isOffline.collectAsStateWithLifecycle()
    val pullRefreshState = rememberPullRefreshState(
        refreshing = refreshing,
        onRefresh = {
            if (isOffline.not()) {
                scope.launch { viewModel.getFeed() }
            }
        }
    )
    val buttonText = stringResource(R.string.get_results)
    val notConnectedMessage = stringResource(R.string.not_connected)
    val feedApiError = stringResource(R.string.feed_error)
    val context = LocalContext.current
    var topBarTitle = remember { context.getString(R.string.app_name) }
    val state by viewModel.feedFlowUiState.collectAsStateWithLifecycle()

    LaunchedEffect(isOffline) {
        if (isOffline) {
            snackBarHostState.showSnackbar(
                message = notConnectedMessage,
                duration = SnackbarDuration.Indefinite,
            )
        }
    }
    Scaffold(
        topBar = { SportsNetworkTopBar { topBarTitle } },
        snackbarHost = { SnackbarHost(snackBarHostState) },
    ) { padding ->
        Box(
            modifier = Modifier
                .pullRefresh(pullRefreshState)
                .padding(padding)
                .fillMaxSize()
                .background(color = SportsNetworkTheme.colors.backgroundPrimary),
            contentAlignment = Alignment.Center
        ) {
            ViewStateScaffold(
                viewState = state,
                modifier = Modifier.wrapContentSize(),
                loading = { },
                showFeed = {
                    if (it.feedList.isNullOrEmpty()) {
                        showFeeApiError(viewModel, scope, snackBarHostState, feedApiError)
                    } else {
                        it.feedList.firstOrNull()?.publicationDate?.let { title ->
                            topBarTitle = stringResource(id = R.string.results_for, title)
                        }
                        Feed { it }
                    }
                },
                failure = { showFeeApiError(viewModel, scope, snackBarHostState, feedApiError) },
                idle = {
                    SportNetworkButton(text = { buttonText }) {
                        scope.launch { viewModel.getFeed() }
                    }
                }
            )

            PullRefreshIndicator(
                refreshing = refreshing,
                state = pullRefreshState,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
    }
}

private fun showFeeApiError(
    viewModel: FeedViewModel,
    scope: CoroutineScope,
    snackBarHostState: SnackbarHostState,
    message: String
) {
    viewModel.updateUiState(FeedFlowUiState.Idle)
    scope.launch {
        snackBarHostState.showSnackbar(
            message = message,
            duration = SnackbarDuration.Long,
        )
    }
}
