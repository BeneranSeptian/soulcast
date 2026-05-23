package dev.septianbeneran.soulcast.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.septianbeneran.soulcast.data.experiences
import dev.septianbeneran.soulcast.ui.components.*
import org.jetbrains.compose.resources.painterResource
import soulcast.shared.generated.resources.Res
import soulcast.shared.generated.resources.profile_pic

@Composable
fun PortfolioScreen() {
    val uriHandler = LocalUriHandler.current
    val scrollState = rememberLazyListState()
    
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val isMobile = maxWidth < 800.dp
        val horizontalPadding = if (isMobile) 24.dp else 64.dp

        AnimatedBackground()

        Column(modifier = Modifier.fillMaxSize()) {
            NavBar(
                onContactClick = { uriHandler.openUri("mailto:m.septiann@gmail.com") },
                onDownloadCVClick = { uriHandler.openUri("https://flowcv.com/resume/dw99tao12u") },
                isMobile = isMobile
            )

            LazyColumn(
                state = scrollState,
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 64.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    SectionWrapper(
                        modifier = Modifier.padding(top = 64.dp, bottom = 100.dp),
                        enter = fadeIn(animationSpec = tween(1500))
                    ) {
                        HeroSection(isMobile)
                    }
                }

                item {
                    SectionWrapper(modifier = Modifier.padding(vertical = 100.dp)) {
                        ExperienceSection(isMobile)
                    }
                }

                item {
                    Footer()
                }
            }
        }
    }
}

@Composable
fun SectionWrapper(
    modifier: Modifier = Modifier,
    enter: EnterTransition = fadeIn(animationSpec = tween(1000)) + slideInVertically(
        initialOffsetY = { 50 },
        animationSpec = tween(1000)
    ),
    content: @Composable () -> Unit
) {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }

    AnimatedVisibility(
        visible = visible,
        enter = enter,
        modifier = modifier
            .widthIn(max = 1200.dp)
            .padding(horizontal = 24.dp)
    ) {
        content()
    }
}

@Composable
fun HeroSection(isMobile: Boolean) {
    if (isMobile) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.profile_pic),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(48.dp))
            ProfileInfo(
                isCentered = true,
                isMobile = isMobile
            )
        }
    } else {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1.2f)) {
                ProfileInfo(
                    isCentered = false,
                    isMobile = isMobile
                )
            }
            Spacer(modifier = Modifier.width(64.dp))
            Box(modifier = Modifier.weight(0.8f), contentAlignment = Alignment.CenterEnd) {
                Image(
                    painter = painterResource(Res.drawable.profile_pic),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(380.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun ExperienceSection(isMobile: Boolean) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (isMobile) Alignment.CenterHorizontally else Alignment.Start
    ) {
        Text(
            text = "Professional Experience",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        )
        Spacer(modifier = Modifier.height(48.dp))
        experiences.forEach { exp ->
            ExperienceItem(exp, isMobile)
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
