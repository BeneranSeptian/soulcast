package dev.septianbeneran.soulcast.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun FadeInSection(
    index: Int = 0,
    delayPerIndex: Long = 120L,
    content: @Composable () -> Unit
) {
    var visible by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(if (visible) 1f else 0f)
    val offsetY by animateDpAsState(if (visible) 0.dp else 40.dp)

    LaunchedEffect(Unit) {
        delay(delayPerIndex * index)
        visible = true
    }

    Box(
        modifier = Modifier
            .alpha(alpha)
            .offset(y = offsetY)
    ) {
        content()
    }
}
