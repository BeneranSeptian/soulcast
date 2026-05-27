package dev.septianbeneran.soulcast.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import dev.septianbeneran.soulcast.ui.theme.LocalThemeState

@Composable
fun AnimatedBackground() {
    val themeColors = LocalThemeState.current.colors
    val infiniteTransition = rememberInfiniteTransition()

    val glowPulse by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 0.6f,
        animationSpec = infiniteRepeatable(
            animation = tween(6000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawRect(color = Color(0xFF0D0B0E))

        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    themeColors.glow.copy(alpha = 0.03f * glowPulse),
                    Color.Transparent
                ),
                center = Offset(canvasWidth * 0.5f, canvasHeight * 1.1f),
                radius = canvasHeight * 0.8f
            ),
            center = Offset(canvasWidth * 0.5f, canvasHeight * 1.1f),
            radius = canvasHeight * 0.8f
        )
    }
}
