package dev.septianbeneran.soulcast.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.hoverable
import dev.septianbeneran.soulcast.ui.theme.Accent
import dev.septianbeneran.soulcast.ui.theme.SurfaceDark
import dev.septianbeneran.soulcast.ui.theme.SurfaceElevated
import dev.septianbeneran.soulcast.ui.theme.TextSecondary
import dev.septianbeneran.soulcast.ui.theme.TextTertiary

data class TechItem(val name: String)

val techStack = listOf(
    TechItem("Kotlin"),
    TechItem("Jetpack Compose"),
    TechItem("Compose Multiplatform"),
    TechItem("Android SDK"),
    TechItem("Coroutines"),
    TechItem("Flow"),
    TechItem("Hilt / Koin"),
    TechItem("Retrofit"),
    TechItem("Room"),
    TechItem("React Native"),
    TechItem("Javascript"),
    TechItem("Typescript"),
    TechItem("Firebase"),
    TechItem("Git"),
    TechItem("CI / CD")
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TechStackSection(isMobile: Boolean) {
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

@Composable
fun TechChip(name: String) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    
    val animatedScale by animateFloatAsState(if (isHovered) 1.02f else 1f)

    Surface(
        modifier = Modifier
            .scale(animatedScale)
            .hoverable(interactionSource),
        color = if (isHovered) SurfaceElevated else SurfaceDark,
        shape = RoundedCornerShape(6.dp),
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Medium,
                color = if (isHovered) TextSecondary else TextTertiary
            ),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}
