package com.pd.palette.compose

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Shapes
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pd.palette.compose.theme.TundoraTheme

val SportsNetworkTheme = TundoraTheme

val fontFamily = FontFamily.Default

val SportsNetworkShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(16.dp)
)

@Composable
fun SportsNetworkTheme(darkTheme: Boolean = isNightMode(), content: @Composable () -> Unit) {
    SportsNetworkTheme.darkTheme = darkTheme
    val spacing = SportsNetworkTheme.spacing
    val sizes = SportsNetworkTheme.sizes
    val typography = SportsNetworkTheme.typography
    val colors = SportsNetworkTheme.colors
    val localTypography = SportsNetworkTheme.localTypography
    val localColors = if (darkTheme) SportsNetworkTheme.localDarkColors else SportsNetworkTheme.localLightColors
    val localSpacing = SportsNetworkTheme.localSpacing
    val localSizes = SportsNetworkTheme.localSizes

    val defaultMaterialColors = Colors(
        primary = colors.accentPrimary,
        secondary = colors.accentSecondary,
        background = colors.backgroundSecondary,
        surface = colors.backgroundPrimary,
        error = colors.alertPrimary,
        onPrimary = colors.backgroundSecondary,
        onBackground = colors.backgroundSecondaryContrary,
        onSurface = colors.backgroundSecondaryContrary,
        onError = colors.alertPrimary,
        isLight = darkTheme,
        onSecondary = colors.backgroundSecondary,
        primaryVariant = colors.accentPrimary,
        secondaryVariant = colors.accentSecondary
    )

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = darkTheme.not()
    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(
            color = colors.backgroundSecondary,
            darkIcons = useDarkIcons
        )
        onDispose { /*No-Op*/ }
    }

    CompositionLocalProvider(
        localSpacing provides spacing,
        localSizes provides sizes,
        localTypography provides typography,
        localColors provides colors
    ) {
        ProvideTextStyle(value = TextStyle(fontFamily = fontFamily)) {
            Surface(color = colors.backgroundPrimary, contentColor = colors.textPrimary) {
                MaterialTheme(
                    content = content,
                    shapes = SportsNetworkShapes,
                    colors = defaultMaterialColors,
                )
            }
        }
    }
}

@Composable
fun isNightMode() = when (AppCompatDelegate.getDefaultNightMode()) {
    AppCompatDelegate.MODE_NIGHT_NO -> false
    AppCompatDelegate.MODE_NIGHT_YES -> true
    else -> isSystemInDarkTheme()
}
