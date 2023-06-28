package com.pd.palette.compose.theme

import com.pd.palette.compose.colors.SportsNetworkColors
import com.pd.palette.compose.colors.TundoraDarkColors
import com.pd.palette.compose.colors.TundoraLightColors
import com.pd.palette.compose.sizes.SportsNetworkSizes
import com.pd.palette.compose.sizes.TundoraSizes
import com.pd.palette.compose.spacing.SportsNetworkSpacing
import com.pd.palette.compose.spacing.TundoraSpacing
import com.pd.palette.compose.typography.SportsNetworkTypography
import com.pd.palette.compose.typography.TundoraTypography

object TundoraTheme : SportsNetworkTheme() {
    override val getTypography: SportsNetworkTypography
        get() = TundoraTypography

    override val getLightColors: SportsNetworkColors
        get() = TundoraLightColors

    override val getDarkColors: SportsNetworkColors
        get() = TundoraDarkColors

    override val getSpacing: SportsNetworkSpacing
        get() = TundoraSpacing

    override val getSizes: SportsNetworkSizes
        get() = TundoraSizes
}
