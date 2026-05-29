package dev.septianbeneran.soulcast.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.septianbeneran.soulcast.data.Project
import org.jetbrains.compose.resources.painterResource
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Github

@Composable
fun ProjectItem(
    project: Project,
    index: Int,
    isMobile: Boolean,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val primaryColor = MaterialTheme.colorScheme.primary
    val surfaceColor = MaterialTheme.colorScheme.surface
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface

    Card(
        modifier = modifier
            .fillMaxSize()
            .hoverable(interactionSource),
        colors = CardDefaults.cardColors(
            containerColor = if (isHovered) surfaceColor else surfaceColor.copy(alpha = 0.65f)
        ),
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isHovered) 3.dp else 0.dp
        ),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            if (isHovered) primaryColor.copy(alpha = 0.2f) else Color.Transparent
        )
    ) {
        Column {
            BinderSpiralStrip(
                primaryColor = primaryColor,
                isHovered = isHovered
            )

            Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 14.dp, bottom = 20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    project.logoRes?.let { res ->
                        Image(
                            painter = painterResource(res),
                            contentDescription = "${project.name} logo",
                            modifier = Modifier
                                .size(28.dp)
                                .clip(RoundedCornerShape(6.dp)),
                            contentScale = ContentScale.Fit
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    }

                    Text(
                        text = project.name,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = onSurfaceColor
                        ),
                        modifier = Modifier.weight(1f)
                    )

                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        project.githubUrl?.let { url ->
                            IconButton(
                                onClick = { uriHandler.openUri(url) },
                                modifier = Modifier.size(28.dp)
                            ) {
                                Icon(
                                    imageVector = FontAwesomeIcons.Brands.Github,
                                    contentDescription = "GitHub",
                                    modifier = Modifier.size(16.dp),
                                    tint = if (isHovered) primaryColor else onSurfaceColor.copy(alpha = 0.4f)
                                )
                            }
                        }
                        project.liveUrl?.let { url ->
                            IconButton(
                                onClick = { uriHandler.openUri(url) },
                                modifier = Modifier.size(28.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.OpenInNew,
                                    contentDescription = "Live Demo",
                                    modifier = Modifier.size(16.dp),
                                    tint = if (isHovered) primaryColor else onSurfaceColor.copy(alpha = 0.4f)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = project.description,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = onSurfaceColor.copy(alpha = 0.7f),
                        lineHeight = 22.sp
                    )
                )

                Spacer(modifier = Modifier.height(14.dp))

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    project.techStack.forEach { tech ->
                        Box(
                            modifier = Modifier
                                .border(
                                    1.dp,
                                    primaryColor.copy(alpha = 0.12f),
                                    RoundedCornerShape(3.dp)
                                )
                                .background(primaryColor.copy(alpha = 0.06f))
                                .padding(horizontal = 7.dp, vertical = 3.dp)
                        ) {
                            Text(
                                text = tech,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = primaryColor.copy(alpha = 0.8f),
                                    fontWeight = FontWeight.Medium,
                                    letterSpacing = 0.5.sp,
                                    fontSize = 11.sp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun BinderSpiralStrip(
    primaryColor: Color,
    isHovered: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                if (isHovered) primaryColor.copy(alpha = 0.08f) else primaryColor.copy(alpha = 0.04f)
            )
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(22.dp)
        ) {
            val w = size.width
            val h = size.height
            val spacing = 28.dp.toPx()
            val count = ((w - spacing) / spacing).toInt().coerceAtLeast(1)
            val startX = (w - (count - 1) * spacing) / 2f

            for (i in 0 until count) {
                val cx = startX + i * spacing

                drawCircle(
                    color = primaryColor.copy(alpha = 0.2f),
                    radius = 3.5.dp.toPx(),
                    center = Offset(cx, h / 2f),
                    style = Stroke(width = 1.5.dp.toPx())
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .height(1.dp)
                .background(primaryColor.copy(alpha = 0.06f))
        )
    }
}
