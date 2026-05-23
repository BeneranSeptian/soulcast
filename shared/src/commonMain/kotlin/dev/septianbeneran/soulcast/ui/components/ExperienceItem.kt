package dev.septianbeneran.soulcast.ui.components

import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.septianbeneran.soulcast.data.WorkExperience
import dev.septianbeneran.soulcast.ui.theme.NeonGreen
import dev.septianbeneran.soulcast.ui.theme.SurfaceDark
import dev.septianbeneran.soulcast.ui.theme.TextPrimary
import dev.septianbeneran.soulcast.ui.theme.TextSecondary

@Composable
fun ExperienceItem(exp: WorkExperience, isMobile: Boolean) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    
    val animatedElevation by animateDpAsState(if (isHovered) 12.dp else 2.dp)
    val animatedScale by animateFloatAsState(if (isHovered) 1.02f else 1f)
    val animatedBorderAlpha by animateFloatAsState(if (isHovered) 0.8f else 0.2f)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .hoverable(interactionSource)
            .scale(animatedScale)
    ) {
        if (!isMobile) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(40.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(if (isHovered) NeonGreen else NeonGreen.copy(alpha = 0.5f))
                )
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .fillMaxHeight()
                        .weight(1f)
                        .background(NeonGreen.copy(alpha = 0.2f))
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }

        Card(
            modifier = Modifier.weight(1f),
            colors = CardDefaults.cardColors(containerColor = SurfaceDark),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = animatedElevation),
            border = BorderStroke(1.dp, NeonGreen.copy(alpha = animatedBorderAlpha))
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = exp.position,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = NeonGreen
                            )
                        )
                        Text(
                            text = exp.company,
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = TextPrimary,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                    if (!isMobile) {
                        Surface(
                            color = NeonGreen.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = exp.duration,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                                style = MaterialTheme.typography.labelMedium.copy(
                                    color = NeonGreen,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }
                    }
                }
                if (isMobile) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = exp.duration,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = TextSecondary,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = exp.description,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        lineHeight = 26.sp,
                        color = TextSecondary
                    )
                )
            }
        }
    }
}
