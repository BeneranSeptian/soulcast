package dev.septianbeneran.soulcast.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import dev.septianbeneran.soulcast.ui.theme.Accent
import dev.septianbeneran.soulcast.ui.theme.TextPrimary
import dev.septianbeneran.soulcast.ui.theme.TextSecondary

@Composable
fun ProfileInfo(
    isCentered: Boolean,
    isMobile: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = if (isCentered) Alignment.CenterHorizontally else Alignment.Start
    ) {
        Text(
            text = "Android Developer",
            style = MaterialTheme.typography.labelLarge.copy(
                color = Accent,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 2.sp
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Muhammad Seftian\nNurfaozy",
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.Bold,
                color = TextPrimary,
                lineHeight = 1.1.em
            ),
            textAlign = if (isCentered) TextAlign.Center else TextAlign.Start
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Building scalable, maintainable mobile applications with modern Android technologies. Passionate about clean architecture and great user experiences.",
            style = MaterialTheme.typography.bodyLarge.copy(
                lineHeight = 28.sp,
                color = TextSecondary
            ),
            textAlign = if (isCentered) TextAlign.Center else TextAlign.Start
        )
        
        Spacer(modifier = Modifier.height(40.dp))

        TechStackSection(isMobile = isMobile)
    }
}
