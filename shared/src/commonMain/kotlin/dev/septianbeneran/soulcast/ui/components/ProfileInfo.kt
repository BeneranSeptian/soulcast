package dev.septianbeneran.soulcast.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Surface(
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
        ) {
            Text(
                text = "3+ Years Experience",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                style = MaterialTheme.typography.labelMedium.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Muhammad Seftian Nurfaozy",
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            ),
            textAlign = if (isCentered) TextAlign.Center else TextAlign.Start
        )
        Text(
            text = "Android Developer",
            style = MaterialTheme.typography.headlineSmall.copy(
                color = TextSecondary
            ),
            textAlign = if (isCentered) TextAlign.Center else TextAlign.Start
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Experienced Android Developer who loves challenges. Passionate about building scalable, maintainable mobile applications using modern Android technologies. Always eager to learn, improve, and take on complex problems.",
            style = MaterialTheme.typography.bodyLarge.copy(
                lineHeight = 28.sp,
                color = TextPrimary
            ),
            textAlign = if (isCentered) TextAlign.Center else TextAlign.Start
        )
        
        Spacer(modifier = Modifier.height(32.dp))

        TechStackSection(isMobile = isMobile)
    }
}
