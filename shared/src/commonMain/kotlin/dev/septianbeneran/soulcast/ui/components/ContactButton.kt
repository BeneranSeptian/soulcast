package dev.septianbeneran.soulcast.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import dev.septianbeneran.soulcast.ui.theme.Accent
import dev.septianbeneran.soulcast.ui.theme.SurfaceDark
import dev.septianbeneran.soulcast.ui.theme.SurfaceElevated
import dev.septianbeneran.soulcast.ui.theme.TextSecondary
import dev.septianbeneran.soulcast.ui.theme.TextTertiary

@Composable
fun ContactButton(icon: ImageVector, contentDescription: String, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val scale by animateFloatAsState(if (isHovered) 1.05f else 1f)

    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(44.dp)
            .scale(scale)
            .hoverable(interactionSource),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = if (isHovered) SurfaceElevated else SurfaceDark
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(20.dp),
            tint = if (isHovered) TextSecondary else TextTertiary
        )
    }
}
