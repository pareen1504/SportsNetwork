package com.pd.feed.feed

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.pd.feed.composables.screens.FeedScreen
import com.pd.palette.compose.SportsNetworkTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SportsNetworkTheme {
                FeedScreen()
            }
        }
    }
}
