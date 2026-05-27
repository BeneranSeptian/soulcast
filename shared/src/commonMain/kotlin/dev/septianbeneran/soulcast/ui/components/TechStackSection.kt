package dev.septianbeneran.soulcast.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TechItem(val name: String)

val techStack = listOf(
    TechItem("Kotlin"),
    TechItem("Jetpack Compose"),
    TechItem("Android SDK"),
    TechItem("Coroutines"),
    TechItem("Flow"),
    TechItem("Hilt"),
    TechItem("Koin"),
    TechItem("Retrofit"),
    TechItem("Room"),
    TechItem("Firebase"),
    TechItem("Git"),
    TechItem("CI / CD")
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TechStackSection(isMobile: Boolean) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val tertiaryColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)

    Column {
        Text(
            text = "TECH STACK",
            style = MaterialTheme.typography.labelSmall.copy(
                color = tertiaryColor,
                letterSpacing = 3.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = if (isMobile) Arrangement.Center else Arrangement.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            techStack.forEach { tech ->
                TechChip(tech.name)
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Composable
fun TechChip(name: String) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val primaryColor = MaterialTheme.colorScheme.primary
    val surfaceColor = MaterialTheme.colorScheme.surface
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface
    
    val animatedScale by animateFloatAsState(if (isHovered) 1.02f else 1f)

    Surface(
        modifier = Modifier
            .scale(animatedScale)
            .hoverable(interactionSource),
        color = surfaceColor,
        shape = RoundedCornerShape(2.dp),
        border = BorderStroke(
            1.dp,
            if (isHovered) primaryColor.copy(alpha = 0.3f) else primaryColor.copy(alpha = 0.08f)
        )
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Medium,
                color = if (isHovered) primaryColor else onSurfaceColor.copy(alpha = 0.5f),
                letterSpacing = 0.5.sp
            ),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}
