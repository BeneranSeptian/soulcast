package dev.septianbeneran.soulcast.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Custom Colors for Dark Theme with Neon Green Accents
val BackgroundDark = Color(0xFF121212)
val SurfaceDark = Color(0xFF1E1E1E)
val NeonGreen = Color(0xFF39FF14)
val TextPrimary = Color(0xFFE0E0E0)
val TextSecondary = Color(0xFFB0B0B0)
val NeonGreenTransparent = NeonGreen.copy(alpha = 0.1f)

@Composable
fun PortfolioTheme(content: @Composable () -> Unit) {
    val colorScheme = darkColorScheme(
        primary = NeonGreen,
        background = BackgroundDark,
        surface = SurfaceDark,
        onPrimary = Color.Black,
        onBackground = TextPrimary,
        onSurface = TextPrimary,
    )

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
