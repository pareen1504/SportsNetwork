package com.pd.palette.compose.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import com.pd.palette.compose.colors.SportsNetworkColors
import com.pd.palette.compose.sizes.SportsNetworkSizes
import com.pd.palette.compose.spacing.SportsNetworkSpacing
import com.pd.palette.compose.typography.SportsNetworkTypography

abstract class SportsNetworkTheme {
    protected abstract val getTypography: SportsNetworkTypography
    protected abstract val getLightColors: SportsNetworkColors
    protected abstract val getDarkColors: SportsNetworkColors
    protected abstract val getSpacing: SportsNetworkSpacing
    protected abstract val getSizes: SportsNetworkSizes
    var darkTheme: Boolean = false

    internal val localTypography = compositionLocalOf {
        getTypography
    }

    internal val localLightColors = compositionLocalOf {
        getLightColors
    }

    internal val localDarkColors = compositionLocalOf {
        getDarkColors
    }

    internal val localSpacing = compositionLocalOf {
        getSpacing
    }

    internal val localSizes = compositionLocalOf {
        getSizes
    }

    val typography: SportsNetworkTypography
        @Composable get() = localTypography.current

    val colors: SportsNetworkColors
        @Composable get() = if (darkTheme) localDarkColors.current else localLightColors.current

    val spacing: SportsNetworkSpacing
        @Composable get() = localSpacing.current

    val sizes: SportsNetworkSizes
        @Composable get() = localSizes.current
}
