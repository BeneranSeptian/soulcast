package dev.septianbeneran.soulcast.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

val BackgroundDark = Color(0xFF0D0B0E)
val SurfaceDark = Color(0xFF1A171E)

data class ThemeColors(
    val primary: Color,
    val glow: Color,
    val secondary: Color
)

val themePalettes = listOf(
    ThemeColors(Color(0xFFC4956A), Color(0xFFE8B86D), Color(0xFFB87333)),
    ThemeColors(Color(0xFF6B8F71), Color(0xFFA8D5B0), Color(0xFF4A7A52)),
    ThemeColors(Color(0xFF7B8FBF), Color(0xFFB8C8E8), Color(0xFF5A6F9E)),
    ThemeColors(Color(0xFFB07B8F), Color(0xFFE0B0C0), Color(0xFF8E5A6E)),
    ThemeColors(Color(0xFF9B8BB0), Color(0xFFD0C0E0), Color(0xFF7A6A8E)),
    ThemeColors(Color(0xFF8FA07B), Color(0xFFC8D5B0), Color(0xFF6E805A)),
    ThemeColors(Color(0xFFBF9B7B), Color(0xFFE8D0B0), Color(0xFF9E7A5A)),
    ThemeColors(Color(0xFF7B9FA0), Color(0xFFB0D5D6), Color(0xFF5A8080)),
)

data class PortfolioThemeState(
    val paletteIndex: Int = 0
) {
    val colors: ThemeColors get() = themePalettes[paletteIndex]
}

val LocalThemeState = compositionLocalOf { PortfolioThemeState() }

@Composable
fun PortfolioTheme(
    themeState: PortfolioThemeState = PortfolioThemeState(),
    content: @Composable () -> Unit
) {
    val colors = themeState.colors

    val colorScheme = darkColorScheme(
        primary = colors.primary,
        secondary = colors.secondary,
        background = BackgroundDark,
        surface = SurfaceDark,
        onPrimary = BackgroundDark,
        onBackground = Color(0xFFEDE4D8),
        onSurface = Color(0xFFEDE4D8),
    )

    CompositionLocalProvider(LocalThemeState provides themeState) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}
