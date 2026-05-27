package dev.septianbeneran.soulcast.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun NavBar(
    scrollState: LazyListState,
    onDownloadCVClick: () -> Unit,
    isMobile: Boolean,
    currentSectionIndex: Int = 0
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface
    val scope = rememberCoroutineScope()
    var isMenuOpen by remember { mutableStateOf(false) }

    fun scrollToSection(index: Int) {
        scope.launch {
            scrollState.animateScrollToItem(index)
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        color = MaterialTheme.colorScheme.background.copy(alpha = 0.95f),
        tonalElevation = 0.dp
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
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = primaryColor,
                        letterSpacing = 4.sp
                    )
                )

                if (isMobile) {
                    IconButton(onClick = { isMenuOpen = !isMenuOpen }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu", tint = onSurfaceColor.copy(alpha = 0.5f))
                    }
                } else {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        NavTextButton(
                            label = "Home",
                            isSelected = currentSectionIndex == 0,
                            onClick = { scrollToSection(0) }
                        )
                        NavTextButton(
                            label = "Experience",
                            isSelected = currentSectionIndex == 1,
                            onClick = { scrollToSection(1) }
                        )
                        NavTextButton(
                            label = "Projects",
                            isSelected = currentSectionIndex == 2,
                            onClick = { scrollToSection(2) }
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Button(
                            onClick = onDownloadCVClick,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = primaryColor,
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(4.dp),
                            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
                        ) {
                            Text("Download CV", fontWeight = FontWeight.SemiBold)
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
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    NavTextButton(
                        label = "Home",
                        isSelected = currentSectionIndex == 0,
                        onClick = { scrollToSection(0); isMenuOpen = false }
                    )
                    NavTextButton(
                        label = "Experience",
                        isSelected = currentSectionIndex == 1,
                        onClick = { scrollToSection(1); isMenuOpen = false }
                    )
                    NavTextButton(
                        label = "Projects",
                        isSelected = currentSectionIndex == 2,
                        onClick = { scrollToSection(2); isMenuOpen = false }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = { onDownloadCVClick(); isMenuOpen = false },
                        modifier = Modifier.fillMaxWidth(0.8f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = primaryColor,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text("Download CV", fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }
}

@Composable
private fun NavTextButton(
    label: String,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextButton(onClick = onClick) {
            Text(
                text = label,
                color = if (isSelected) primaryColor else onSurfaceColor.copy(alpha = 0.5f),
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Medium,
                letterSpacing = 1.sp
            )
        }
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(2.dp)
                .background(
                    if (isSelected) primaryColor else Color.Transparent,
                    RoundedCornerShape(1.dp)
                )
        )
    }
}
