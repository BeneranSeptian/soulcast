package dev.septianbeneran.soulcast.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.septianbeneran.soulcast.ui.components.AnimatedBackground
import dev.septianbeneran.soulcast.ui.theme.NeonGreen
import dev.septianbeneran.soulcast.ui.theme.TextPrimary
import dev.septianbeneran.soulcast.ui.theme.TextSecondary

@Composable
fun NotFoundScreen() {
    val uriHandler = LocalUriHandler.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        AnimatedBackground()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                text = "404",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontSize = 120.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = NeonGreen,
                    letterSpacing = 8.sp
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "OOPS! PAGE NOT FOUND",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    letterSpacing = 2.sp
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "The page you are looking for might have been removed, had its name changed, or is temporarily unavailable.",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = TextSecondary,
                    lineHeight = 28.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.widthIn(max = 500.dp)
            )

            Spacer(modifier = Modifier.height(48.dp))

            Button(
                onClick = { uriHandler.openUri("/") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = NeonGreen,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.height(56.dp).width(200.dp)
            ) {
                Text(
                    text = "BACK TO HOME",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 1.sp
                    )
                )
            }
        }
    }
}
