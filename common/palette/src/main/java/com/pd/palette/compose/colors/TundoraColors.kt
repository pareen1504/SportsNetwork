package com.pd.palette.compose.colors

import androidx.compose.ui.graphics.Color

val TundoraLightColors = SportsNetworkColors(
    isLight = true,
    // background
    backgroundPrimary = Color(0xFFF8F7F3),
    backgroundSecondary = Color(0xFFFFFFFF),
    backgroundTertiary = Color(0xFFE8E8E3),
    backgroundQuaternary = Color(0xFFEFEFEA),
    backgroundQuinary = Color(0xFFE2E1DE),
    backgroundSenary = Color(0xFFF3F3F3),
    backgroundSeptenary = Color(0xFFEAEBDC),
    backgroundOctonary = Color(0xFFDCDDBE),
    backgroundSecondaryContrary = Color(0xFF353535),
    backgroundScrim = Color(0xFF000000),
    backgroundPremium = Color(0xFFFFFAE5),
    backgroundLightAccent = Color(0xFFF8F4E4),
    // border
    borderPrimary = Color(0xFFE8E8E3),
    borderSecondary = Color(0xFFEDEDED),
    borderTertiary = Color(0xFF4B4B4B),
    borderQuaternary = Color(0xFF4B4B4B),
    borderQuinary = Color(0xFF565656),
    // accent
    accentPrimary = Color(0xFF4B4B4B),
    accentSecondary = Color(0xFF1E63BD),
    accentTertiary = Color(0xFFEDE4C1),
    accentQuaternary = Color(0xFF5D7681),
    accentQuinary = Color(0xFF809B9D),
    // alert
    alertPrimary = Color(0xFFE84733),
    alertSecondary = Color(0xFF27AE60),
    // text
    textPrimary = Color(0xFF121212),
    textSecondary = Color(0xFF484848),
    textTertiary = Color(0xFF888888),
    textQuaternary = Color(0xFF666666),
    textQuinary = Color(0xFF545445),
    textSecondaryContrary = Color(0xFFFFFFFF),
    textOnAccentPrimary = Color(0xFF403D4A),
    // icon
    iconPrimary = Color(0xFF121212),
    iconSecondary = Color(0xFF888888),
    iconTertiary = Color(0xFF4B4B4B),
    iconQuaternary = Color(0xFF666666),
    iconSecondaryContrary = Color(0xFFFFFFFF),
    iconDisabled = Color(0xFFCACACA),
    iconDisabled50 = Color(0x50CACACA),
    iconQuinary = Color(0xFFFFFFFF),
    // misc
    blueBayoux = Color(0xFF5D7681),
    bismark = Color(0xFF536A73),
    tangerineYellow = Color(0xFFFACD00),
    // button
    buttonTextPrimary = Color(0xFFFFFFFF),
    marigoldYellow = Color(0xFFFFE674),
    gradientPrimary = Color(0xFFFFDF4E),
    gradientSecondary = Color(0xFFEEC300),
    gradientTertiary = Color(0xFFF7A614),
    gradientQuaternary = Color(0xFFE59608),
    squash = Color(0xFFF7A514),
)

val TundoraDarkColors = with(TundoraLightColors) {
    copy(
        isLight = false,
        // background
        backgroundPrimary = Color(0xFF23272F),
        backgroundSecondary = Color(0xFF2B303A),
        backgroundTertiary = Color(0xFF3F4450),
        backgroundQuaternary = Color(0xFF4F5563),
        backgroundQuinary = Color(0xFF737783),
        backgroundSenary = Color(0xFF313642),
        backgroundSecondaryContrary = Color(0xFFD9D9D9),
        backgroundPremium = Color(0xFF313642),
        backgroundLightAccent = Color(0xFF313642),
        // border
        borderPrimary = Color(0xFF373C49),
        borderSecondary = Color(0xFF50545D),
        borderTertiary = Color(0xFF666E86),
        // accent
        accentPrimary = Color(0xFF666E86),
        accentSecondary = Color(0xFF5193EA),
        accentTertiary = Color(0xFFFAE9A4),
        accentQuaternary = Color(0xFFD9D9D9),
        accentQuinary = Color(0xFFD9D9D9),

        // alert
        alertPrimary = Color(0xFFEA6B5C),
        alertSecondary = Color(0xFF27AE60),
        // text
        textPrimary = Color(0xFFD9D9D9),
        textSecondary = Color(0xFFB9B9B9),
        textTertiary = Color(0xFF7D808A),
        textQuaternary = Color(0xFFFFFFFF),
        textSecondaryContrary = Color(0xFF1D1D1D),
        textOnAccentPrimary = Color(0xFFD9D9D9),
        // icon
        iconPrimary = Color(0xFFD9D9D9),
        iconSecondary = Color(0xFF7D808A),
        iconTertiary = Color(0xFF91949C),
        iconQuaternary = Color(0xFF7D808A),
        iconSecondaryContrary = Color(0xFFD9D9D9),
        iconDisabled = Color(0xFF393D44),
        iconDisabled50 = Color(0x50393D44),
        iconQuinary = Color(0xFFFFFFFF),
        // misc
        blueBayoux = Color(0xFF5D7681),
        bismark = Color(0xFF536A73),
        tangerineYellow = Color(0xFFFBD63A),
        // button
        buttonTextPrimary = Color(0xFFD9D9D9),
        backgroundSeptenary = Color(0xFF707686),
        marigoldYellow = Color(0xFFFFE674),
        squash = Color(0xFFF7A514),
        gradientPrimary = Color(0xFFFFDF4E),
        gradientSecondary = Color(0xFFEEC300),
        gradientTertiary = Color(0xFFF7A614),
        gradientQuaternary = Color(0xFFE59608),
    )
}