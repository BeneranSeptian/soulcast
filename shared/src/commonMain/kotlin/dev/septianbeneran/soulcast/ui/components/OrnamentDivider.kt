package dev.septianbeneran.soulcast.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun OrnamentDivider(modifier: Modifier = Modifier) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(24.dp)
    ) {
        val centerY = size.height / 2
        val width = size.width
        val centerX = width / 2

        drawLine(
            color = onSurfaceColor.copy(alpha = 0.1f),
            start = Offset(centerX - 120.dp.toPx(), centerY),
            end = Offset(centerX - 16.dp.toPx(), centerY),
            strokeWidth = 1.dp.toPx(),
            cap = StrokeCap.Round
        )
        drawLine(
            color = onSurfaceColor.copy(alpha = 0.1f),
            start = Offset(centerX + 16.dp.toPx(), centerY),
            end = Offset(centerX + 120.dp.toPx(), centerY),
            strokeWidth = 1.dp.toPx(),
            cap = StrokeCap.Round
        )

        val diamondSize = 6.dp.toPx()
        val diamond = Path().apply {
            moveTo(centerX, centerY - diamondSize)
            lineTo(centerX + diamondSize, centerY)
            lineTo(centerX, centerY + diamondSize)
            lineTo(centerX - diamondSize, centerY)
            close()
        }
        drawPath(diamond, color = primaryColor.copy(alpha = 0.5f))

        val dotRadius = 2.dp.toPx()
        drawCircle(color = primaryColor.copy(alpha = 0.3f), radius = dotRadius, center = Offset(centerX - 16.dp.toPx(), centerY))
        drawCircle(color = primaryColor.copy(alpha = 0.3f), radius = dotRadius, center = Offset(centerX + 16.dp.toPx(), centerY))
    }
}

@Composable
fun SectionHeader(
    title: String,
    modifier: Modifier = Modifier
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    Text(
        text = title,
        style = MaterialTheme.typography.headlineMedium.copy(
            fontWeight = FontWeight.Bold,
            color = primaryColor
        )
    )
    Spacer(modifier = Modifier.height(16.dp))
    OrnamentDivider(modifier)
    Spacer(modifier = Modifier.height(8.dp))
}
