package dev.septianbeneran.soulcast.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import dev.septianbeneran.soulcast.ui.theme.Accent
import dev.septianbeneran.soulcast.ui.theme.BackgroundDark

@Composable
fun AnimatedBackground() {
    val infiniteTransition = rememberInfiniteTransition()
    
    val xOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(30000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    
    val yOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(35000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Accent.copy(alpha = 0.03f), Color.Transparent),
                center = Offset(xOffset % canvasWidth, yOffset % canvasHeight),
                radius = 500f
            ),
            center = Offset(xOffset % canvasWidth, yOffset % canvasHeight),
            radius = 500f
        )
        
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Accent.copy(alpha = 0.02f), Color.Transparent),
                center = Offset((canvasWidth - xOffset) % canvasWidth, (canvasHeight - yOffset) % canvasHeight),
                radius = 700f
            ),
            center = Offset((canvasWidth - xOffset) % canvasWidth, (canvasHeight - yOffset) % canvasHeight),
            radius = 700f
        )
    }
}
