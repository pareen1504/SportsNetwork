package com.pd.common.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pd.palette.compose.SportsNetworkTheme

@Composable
fun SportNetworkButton(
    modifier: Modifier = Modifier,
    @StringRes text: () -> Int,
    enabled: () -> Boolean = { true },
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .fillMaxWidth(fraction = 0.7f)
            .height(48.dp)
            .background(
            color = SportsNetworkTheme.colors.backgroundPrimary,
            shape = RoundedCornerShape(36.dp)
        ),
        shape = RoundedCornerShape(36.dp),
        enabled = enabled(),
        onClick = { onClick.invoke() }) {
        Text(
            text = stringResource(id = text()),
            color = SportsNetworkTheme.colors.buttonTextPrimary,
            textAlign = TextAlign.Center,
            style = SportsNetworkTheme.typography.SubtitleS3.copy(
                letterSpacing = 1.sp
            ),
        )
    }
}