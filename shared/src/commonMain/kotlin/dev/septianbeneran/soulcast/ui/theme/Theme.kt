package dev.septianbeneran.soulcast.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val BackgroundDark = Color(0xFF0F1117)
val SurfaceDark = Color(0xFF1A1D27)
val SurfaceElevated = Color(0xFF232733)
val Accent = Color(0xFF6C9FFF)
val AccentMuted = Color(0xFF4A6FA5)
val TextPrimary = Color(0xFFE8ECF1)
val TextSecondary = Color(0xFF8B95A5)
val TextTertiary = Color(0xFF5A6373)
val Success = Color(0xFF4ADE80)
val Warning = Color(0xFFFBBF24)

@Composable
fun PortfolioTheme(content: @Composable () -> Unit) {
    val colorScheme = darkColorScheme(
        primary = Accent,
        secondary = AccentMuted,
        background = BackgroundDark,
        surface = SurfaceDark,
        onPrimary = Color.White,
        onBackground = TextPrimary,
        onSurface = TextPrimary,
    )

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
