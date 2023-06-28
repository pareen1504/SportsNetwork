package com.pd.sportsnetwork.composables.elements

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pd.palette.compose.SportsNetworkTheme

@Composable
fun DashedLine(
    modifier: Modifier = Modifier,
    color: Color = SportsNetworkTheme.colors.borderPrimary,
    patternSize: Dp = 4.dp,
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(1.dp)
    ) {
        drawLine(
            color = color,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(
                    patternSize.toPx(),
                    patternSize.toPx()
                ),
                0f
            )
        )
    }
}