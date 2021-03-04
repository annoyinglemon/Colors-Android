package kurt.lemond.colors.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*

private val LightColorPalette = lightColors(
    primary = ProductGreyWhite,
    primaryVariant = ProductGreyOnLight,
    secondary = ProductGreyWhite,
    onSecondary = TextColorOnLightSecondary,
    background = ProductWhite,
    onBackground = TextColorOnLight,
    surface = ProductWhite,
    onSurface = TextColorOnLight
)

private val DarkColorPalette = darkColors(
    primary = productGreyDark,
    primaryVariant = ProductBlackOnDark,
    secondary = productGreyDark,
    onSecondary = TextColorOnDarkSecondary,
    background = productDark,
    onBackground = TextColorOnDark,
    surface = productDark,
    onSurface = TextColorOnDark
)

@Composable
fun ColorsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = ColorsAppTypography,
        shapes = Shapes,
        content = content
    )
}