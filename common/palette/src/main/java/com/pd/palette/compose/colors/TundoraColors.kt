package com.pd.palette.compose.colors

import androidx.compose.ui.graphics.Color

val TundoraLightColors = SportsNetworkColors(
    isLight = true,
    // background
    backgroundPrimary = Color(LightColors.backgroundPrimary),
    backgroundSecondary = Color(LightColors.backgroundSecondary),
    backgroundTertiary = Color(LightColors.backgroundTertiary),
    backgroundQuaternary = Color(LightColors.backgroundQuaternary),
    backgroundQuinary = Color(LightColors.backgroundQuinary),
    backgroundSenary = Color(LightColors.backgroundSenary),
    backgroundSeptenary = Color(LightColors.backgroundSeptenary),
    backgroundOctonary = Color(LightColors.backgroundOctonary),
    backgroundSecondaryContrary = Color(LightColors.backgroundSecondaryContrary),
    backgroundScrim = Color(LightColors.backgroundScrim),
    backgroundPremium = Color(LightColors.backgroundPremium),
    backgroundLightAccent = Color(LightColors.backgroundLightAccent),
    // border
    borderPrimary = Color(LightColors.borderPrimary),
    borderSecondary = Color(LightColors.borderSecondary),
    borderTertiary = Color(LightColors.borderTertiary),
    borderQuaternary = Color(LightColors.borderQuaternary),
    borderQuinary = Color(LightColors.borderQuinary),
    // accent
    accentPrimary = Color(LightColors.accentPrimary),
    accentSecondary = Color(LightColors.accentSecondary),
    accentTertiary = Color(LightColors.accentTertiary),
    accentQuaternary = Color(LightColors.accentQuaternary),
    accentQuinary = Color(LightColors.accentQuinary),
    // alert
    alertPrimary = Color(LightColors.alertPrimary),
    alertSecondary = Color(LightColors.alertSecondary),
    // text
    textPrimary = Color(LightColors.textPrimary),
    textSecondary = Color(LightColors.textSecondary),
    textTertiary = Color(LightColors.textTertiary),
    textQuaternary = Color(LightColors.textQuaternary),
    textQuinary = Color(LightColors.textQuinary),
    textSecondaryContrary = Color(LightColors.textSecondaryContrary),
    textOnAccentPrimary = Color(LightColors.textOnAccentPrimary),
    // icon
    iconPrimary = Color(LightColors.iconPrimary),
    iconSecondary = Color(LightColors.iconSecondary),
    iconTertiary = Color(LightColors.iconTertiary),
    iconQuaternary = Color(LightColors.iconQuaternary),
    iconSecondaryContrary = Color(LightColors.iconSecondaryContrary),
    iconDisabled = Color(LightColors.iconDisabled),
    iconDisabled50 = Color(LightColors.iconDisabled50),
    iconQuinary = Color(LightColors.iconQuinary),
    // misc
    blueBayoux = Color(LightColors.blueBayoux),
    bismark = Color(LightColors.bismark),
    tangerineYellow = Color(LightColors.tangerineYellow),
    // button
    buttonTextPrimary = Color(LightColors.buttonTextPrimary),
    marigoldYellow = Color(LightColors.marigoldYellow),
    gradientPrimary = Color(LightColors.gradientPrimary),
    gradientSecondary = Color(LightColors.gradientSecondary),
    gradientTertiary = Color(LightColors.gradientTertiary),
    gradientQuaternary = Color(LightColors.gradientQuaternary),
    squash = Color(LightColors.squash),
)

val TundoraDarkColors = with(TundoraLightColors) {
    copy(
        isLight = false,
        // background
        backgroundPrimary = Color(DarkColors.backgroundPrimary),
        backgroundSecondary = Color(DarkColors.backgroundSecondary),
        backgroundTertiary = Color(DarkColors.backgroundTertiary),
        backgroundQuaternary = Color(DarkColors.backgroundQuaternary),
        backgroundQuinary = Color(DarkColors.backgroundQuinary),
        backgroundSenary = Color(DarkColors.backgroundSenary),
        backgroundSecondaryContrary = Color(DarkColors.backgroundSecondaryContrary),
        backgroundPremium = Color(DarkColors.backgroundPremium),
        backgroundLightAccent = Color(DarkColors.backgroundLightAccent),
        // border
        borderPrimary = Color(DarkColors.borderPrimary),
        borderSecondary = Color(DarkColors.borderSecondary),
        borderTertiary = Color(DarkColors.borderTertiary),
        // accent
        accentPrimary = Color(DarkColors.accentPrimary),
        accentSecondary = Color(DarkColors.accentSecondary),
        accentTertiary = Color(DarkColors.accentTertiary),
        accentQuaternary = Color(DarkColors.accentQuaternary),
        accentQuinary = Color(DarkColors.accentQuinary),

        // alert
        alertPrimary = Color(DarkColors.alertPrimary),
        alertSecondary = Color(DarkColors.alertSecondary),
        // text
        textPrimary = Color(DarkColors.textPrimary),
        textSecondary = Color(DarkColors.textSecondary),
        textTertiary = Color(DarkColors.textTertiary),
        textQuaternary = Color(DarkColors.textQuaternary),
        textSecondaryContrary = Color(DarkColors.textSecondaryContrary),
        textOnAccentPrimary = Color(DarkColors.textOnAccentPrimary),
        // icon
        iconPrimary = Color(DarkColors.iconPrimary),
        iconSecondary = Color(DarkColors.iconSecondary),
        iconTertiary = Color(DarkColors.iconTertiary),
        iconQuaternary = Color(DarkColors.iconQuaternary),
        iconSecondaryContrary = Color(DarkColors.iconSecondaryContrary),
        iconDisabled = Color(DarkColors.iconDisabled),
        iconDisabled50 = Color(DarkColors.iconDisabled50),
        iconQuinary = Color(DarkColors.iconQuinary),
        // misc
        blueBayoux = Color(DarkColors.blueBayoux),
        bismark = Color(DarkColors.bismark),
        tangerineYellow = Color(DarkColors.tangerineYellow),
        // button
        buttonTextPrimary = Color(DarkColors.buttonTextPrimary),
        backgroundSeptenary = Color(DarkColors.backgroundSeptenary),
        marigoldYellow = Color(DarkColors.marigoldYellow),
        squash = Color(DarkColors.squash),
        gradientPrimary = Color(DarkColors.gradientPrimary),
        gradientSecondary = Color(DarkColors.gradientSecondary),
        gradientTertiary = Color(DarkColors.gradientTertiary),
        gradientQuaternary = Color(DarkColors.gradientQuaternary),
    )
}
