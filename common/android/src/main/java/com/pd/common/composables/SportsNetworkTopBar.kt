package com.pd.common.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pd.common.R
import com.pd.palette.compose.SportsNetworkTheme

@Composable
fun SportsNetworkTopBar(titleRes: () -> String? = { null }) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = SportsNetworkTheme.colors.backgroundPrimary,
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 12.dp),
            text = titleRes() ?: stringResource(id = R.string.app_name),
            style = SportsNetworkTheme.typography.TitleT1.copy(
                textAlign = TextAlign.Start
            )
        )
    }
}
