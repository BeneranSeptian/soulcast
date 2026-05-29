package dev.septianbeneran.soulcast.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Footer() {
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Forged with Compose Multiplatform",
            style = MaterialTheme.typography.bodySmall.copy(
                color = onSurfaceColor.copy(alpha = 0.3f),
                fontWeight = FontWeight.Normal,
                letterSpacing = 1.sp
            )
        )
    }
}
