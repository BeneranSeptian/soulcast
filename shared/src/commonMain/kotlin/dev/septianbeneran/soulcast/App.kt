package dev.septianbeneran.soulcast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import dev.septianbeneran.soulcast.ui.components.AnimatedBackground
import dev.septianbeneran.soulcast.ui.components.ContactSection
import dev.septianbeneran.soulcast.ui.components.ExperienceTimeline
import dev.septianbeneran.soulcast.ui.components.FadeInSection
import dev.septianbeneran.soulcast.ui.components.Footer
import dev.septianbeneran.soulcast.ui.components.NavBar
import dev.septianbeneran.soulcast.ui.components.ProjectItem
import dev.septianbeneran.soulcast.ui.components.SectionHeader
import dev.septianbeneran.soulcast.ui.screens.HomeContent
import dev.septianbeneran.soulcast.ui.theme.PortfolioTheme
import dev.septianbeneran.soulcast.ui.theme.PortfolioThemeState
import dev.septianbeneran.soulcast.ui.theme.themePalettes
import dev.septianbeneran.soulcast.data.experiences
import dev.septianbeneran.soulcast.data.projects
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun App() {
    val platform = remember { getPlatform() }
    val uriHandler = LocalUriHandler.current

    var themeState by remember { mutableStateOf(PortfolioThemeState()) }
    val scrollState = rememberLazyListState()
    var currentSection by remember { mutableIntStateOf(0) }

    LaunchedEffect(scrollState) {
        snapshotFlow { scrollState.firstVisibleItemIndex }
            .distinctUntilChanged()
            .collect { index ->
                currentSection = index.coerceIn(0, 2)
            }
    }

    LaunchedEffect(Unit) {
        platform.removeLoadingIndicator()
    }

    PortfolioTheme(themeState = themeState) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            val isMobile = maxWidth < 800.dp

            AnimatedBackground()

            Column(modifier = Modifier.fillMaxSize()) {
                NavBar(
                    scrollState = scrollState,
                    onDownloadCVClick = { uriHandler.openUri("https://flowcv.com/resume/dw99tao12u") },
                    isMobile = isMobile,
                    currentSectionIndex = currentSection
                )

                LazyColumn(
                    state = scrollState,
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item(key = "home") {
                        Box(
                            modifier = Modifier
                                .fillParentMaxHeight()
                                .fillMaxWidth()
                        ) {
                            HomeContent(isMobile = isMobile)
                        }
                    }

                    item(key = "experience") {
                        FadeInSection(index = 1) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = if (isMobile) 24.dp else 64.dp),
                                contentAlignment = Alignment.TopCenter
                            ) {
                                Column(
                                    modifier = Modifier.widthIn(max = 800.dp).padding(vertical = 48.dp),
                                    horizontalAlignment = if (isMobile) Alignment.CenterHorizontally else Alignment.Start
                                ) {
                                    SectionHeader(title = "Experience")
                                    Spacer(modifier = Modifier.height(32.dp))
                                    ExperienceTimeline(
                                        experiences = experiences,
                                        isMobile = isMobile
                                    )
                                }
                            }
                        }
                    }

                    item(key = "projects") {
                        FadeInSection(index = 2) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = if (isMobile) 24.dp else 64.dp),
                                contentAlignment = Alignment.TopCenter
                            ) {
                                Column(
                                    modifier = Modifier.widthIn(max = 960.dp).padding(vertical = 48.dp)
                                ) {
                                    SectionHeader(title = "Projects")
                                    Spacer(modifier = Modifier.height(32.dp))
                                    val chunkSize = if (isMobile) 1 else 2
                                    var projectIndex = 0
                                    projects.chunked(chunkSize).forEach { chunk ->
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(IntrinsicSize.Min),
                                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                                        ) {
                                            chunk.forEach { project ->
                                                ProjectItem(
                                                    project = project,
                                                    index = projectIndex,
                                                    isMobile = isMobile,
                                                    modifier = Modifier.weight(1f)
                                                )
                                                projectIndex++
                                            }
                                            if (chunk.size < chunkSize) {
                                                Spacer(modifier = Modifier.weight(1f))
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(16.dp))
                                    }
                                }
                            }
                        }
                    }

                    item(key = "contact") {
                        FadeInSection(index = 3) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = if (isMobile) 24.dp else 64.dp),
                                contentAlignment = Alignment.TopCenter
                            ) {
                                Column(
                                    modifier = Modifier.widthIn(max = 600.dp).padding(vertical = 48.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    ContactSection()
                                }
                            }
                        }
                    }

                    item(key = "footer") {
                        FadeInSection(index = 4) {
                            Footer()
                        }
                    }
                }
            }

            FloatingActionButton(
                onClick = {
                    val newIndex = (0 until themePalettes.size).filter { it != themeState.paletteIndex }.random()
                    themeState = themeState.copy(paletteIndex = newIndex)
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(24.dp),
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Default.Palette,
                    contentDescription = "Randomize Color"
                )
            }
        }
    }
}
