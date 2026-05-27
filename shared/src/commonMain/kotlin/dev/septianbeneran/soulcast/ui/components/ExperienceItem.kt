package dev.septianbeneran.soulcast.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.septianbeneran.soulcast.data.WorkExperience

@Composable
fun ExperienceTimeline(
    experiences: List<WorkExperience>,
    isMobile: Boolean
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        experiences.forEachIndexed { index, exp ->
            ExperienceItem(
                exp = exp,
                isMobile = isMobile,
                isLast = index == experiences.size - 1
            )
        }
    }
}

@Composable
fun ExperienceItem(
    exp: WorkExperience,
    isMobile: Boolean,
    isLast: Boolean = false
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val primaryColor = MaterialTheme.colorScheme.primary
    val surfaceColor = MaterialTheme.colorScheme.surface
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface
    
    val animatedScale by animateFloatAsState(if (isHovered) 1.01f else 1f)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .hoverable(interactionSource)
    ) {
        if (!isMobile) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(48.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(
                            if (isHovered) primaryColor
                            else primaryColor.copy(alpha = 0.4f)
                        )
                )
                if (!isLast) {
                    Box(
                        modifier = Modifier
                            .width(2.dp)
                            .height(160.dp)
                            .background(primaryColor.copy(alpha = 0.15f))
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
        }

        Card(
            modifier = Modifier
                .weight(1f)
                .scale(animatedScale),
            colors = CardDefaults.cardColors(containerColor = surfaceColor),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            border = BorderStroke(
                1.dp,
                if (isHovered) primaryColor.copy(alpha = 0.3f) else primaryColor.copy(alpha = 0.06f)
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = exp.position,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = onSurfaceColor
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = exp.company,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = primaryColor,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                    Surface(
                        color = primaryColor.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = exp.duration,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = primaryColor,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = exp.description,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        lineHeight = 22.sp,
                        color = onSurfaceColor.copy(alpha = 0.7f)
                    )
                )
            }
        }
    }
    if (!isLast) {
        Spacer(modifier = Modifier.height(16.dp))
    }
}
