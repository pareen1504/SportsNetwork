package com.pd.sportsnetwork.feed

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pd.palette.compose.SportsNetworkTheme
import com.pd.sportsnetwork.composables.screens.FeedScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: FeedViewModel by viewModels()
        setContent {
            SportsNetworkTheme {
                FeedScreen(viewModel = viewModel)
            }
        }
    }
}
