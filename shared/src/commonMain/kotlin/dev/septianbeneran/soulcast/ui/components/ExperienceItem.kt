package dev.septianbeneran.soulcast.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
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
import dev.septianbeneran.soulcast.ui.theme.Accent
import dev.septianbeneran.soulcast.ui.theme.AccentMuted
import dev.septianbeneran.soulcast.ui.theme.SurfaceDark
import dev.septianbeneran.soulcast.ui.theme.SurfaceElevated
import dev.septianbeneran.soulcast.ui.theme.TextPrimary
import dev.septianbeneran.soulcast.ui.theme.TextSecondary
import dev.septianbeneran.soulcast.ui.theme.TextTertiary

@Composable
fun ExperienceItem(exp: WorkExperience, isMobile: Boolean) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    
    val animatedScale by animateFloatAsState(if (isHovered) 1.01f else 1f)

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
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(if (isHovered) Accent else AccentMuted)
                )
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .fillMaxHeight()
                        .weight(1f)
                        .background(TextTertiary.copy(alpha = 0.3f))
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }

        Card(
            modifier = Modifier.weight(1f),
            colors = CardDefaults.cardColors(
                containerColor = if (isHovered) SurfaceElevated else SurfaceDark
            ),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
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
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = TextPrimary
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = exp.company,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = TextSecondary
                            )
                        )
                    }
                    if (!isMobile) {
                        Text(
                            text = exp.duration,
                            style = MaterialTheme.typography.labelMedium.copy(
                                color = TextTertiary,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                }
                if (isMobile) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = exp.duration,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = TextTertiary,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = exp.description,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        lineHeight = 24.sp,
                        color = TextSecondary
                    )
                )
            }
        }
    }
}
