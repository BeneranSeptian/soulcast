package dev.septianbeneran.soulcast.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.septianbeneran.soulcast.ui.theme.NeonGreen

@Composable
fun NavBar(
    onContactClick: () -> Unit,
    onDownloadCVClick: () -> Unit,
    isMobile: Boolean
) {
    var isMenuOpen by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        color = MaterialTheme.colorScheme.background.copy(alpha = 0.8f),
        tonalElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = if (isMobile) 16.dp else 64.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "MSN",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.ExtraBold,
                        color = NeonGreen,
                        letterSpacing = 2.sp
                    )
                )

                if (isMobile) {
                    IconButton(onClick = { isMenuOpen = !isMenuOpen }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu", tint = NeonGreen)
                    }
                } else {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedButton(
                            onClick = onContactClick,
                            border = BorderStroke(1.dp, NeonGreen),
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Text("Contact Me", color = NeonGreen, fontWeight = FontWeight.Bold)
                        }

                        Button(
                            onClick = onDownloadCVClick,
                            colors = ButtonDefaults.buttonColors(containerColor = NeonGreen, contentColor = Color.Black),
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Text("Download CV", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            AnimatedVisibility(
                visible = isMobile && isMenuOpen,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = { onDownloadCVClick(); isMenuOpen = false },
                        modifier = Modifier.fillMaxWidth(0.8f),
                        colors = ButtonDefaults.buttonColors(containerColor = NeonGreen, contentColor = Color.Black),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Download CV", fontWeight = FontWeight.Bold)
                    }

                    OutlinedButton(
                        onClick = { onContactClick(); isMenuOpen = false },
                        modifier = Modifier.fillMaxWidth(0.8f),
                        border = BorderStroke(1.dp, NeonGreen),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Contact Me", color = NeonGreen, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

