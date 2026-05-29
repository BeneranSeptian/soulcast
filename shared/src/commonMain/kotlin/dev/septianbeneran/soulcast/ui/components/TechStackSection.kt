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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class SkillCategory(
    val name: String,
    val skills: List<String>
)

val skillCategories = listOf(
    SkillCategory("Languages", listOf("Kotlin", "TypeScript", "JavaScript")),
    SkillCategory("Frameworks", listOf("Jetpack Compose", "Android SDK", "React Native")),
    SkillCategory("Libraries", listOf("Coroutines", "Flow", "Hilt", "Koin", "Retrofit", "Room")),
    SkillCategory("Tools", listOf("Firebase", "Git", "CI/CD"))
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TechStackSection() {
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TECH STACK",
            style = MaterialTheme.typography.labelSmall.copy(
                color = onSurfaceColor.copy(alpha = 0.4f),
                letterSpacing = 3.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        skillCategories.forEach { category ->
            Text(
                text = category.name,
                style = MaterialTheme.typography.labelSmall.copy(
                    color = onSurfaceColor.copy(alpha = 0.25f),
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.widthIn(max = 500.dp)
            ) {
                category.skills.forEach { skill ->
                    TechChip(skill)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
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

    val animatedScale by animateFloatAsState(if (isHovered) 1.04f else 1f)

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
