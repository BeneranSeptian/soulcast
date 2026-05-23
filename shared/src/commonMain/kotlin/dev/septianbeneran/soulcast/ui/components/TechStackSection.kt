package dev.septianbeneran.soulcast.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.hoverable

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
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        techStack.forEach { tech ->
            TechChip(tech.name)
            Spacer(modifier = Modifier.width(if (isMobile) 8.dp else 12.dp))
        }
    }
}

@Composable
fun TechChip(name: String) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    
    val animatedScale by animateFloatAsState(if (isHovered) 1.05f else 1f)
    val animatedBorderAlpha by animateFloatAsState(if (isHovered) 1f else 0.3f)

    Surface(
        modifier = Modifier
            .scale(animatedScale)
            .hoverable(interactionSource),
        color = if (isHovered) MaterialTheme.colorScheme.primary.copy(alpha = 0.15f) else MaterialTheme.colorScheme.primary.copy(alpha = 0.05f),
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = animatedBorderAlpha)),
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}
