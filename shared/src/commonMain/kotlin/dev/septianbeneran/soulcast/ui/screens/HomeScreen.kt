package dev.septianbeneran.soulcast.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import dev.septianbeneran.soulcast.ui.components.TechStackSection
import org.jetbrains.compose.resources.painterResource
import soulcast.shared.generated.resources.Res
import soulcast.shared.generated.resources.profile_pic

@Composable
fun HomeContent(isMobile: Boolean) {
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 600.dp)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.profile_pic),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(if (isMobile) 140.dp else 160.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "ANDROID DEVELOPER",
                style = MaterialTheme.typography.labelMedium.copy(
                    color = onSurfaceColor.copy(alpha = 0.4f),
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 4.sp
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Muhammad Seftian\nNurfaozy",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = onSurfaceColor,
                    lineHeight = 1.2.em
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Developer with 3+ years of experience in Android development.\nAlways thriving to tackle new challenges in software engineering and building high-quality mobile experiences.",
                style = MaterialTheme.typography.bodyLarge.copy(
                    lineHeight = 26.sp,
                    color = onSurfaceColor.copy(alpha = 0.7f)
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))

            TechStackSection(isMobile = true)
        }
    }
}
