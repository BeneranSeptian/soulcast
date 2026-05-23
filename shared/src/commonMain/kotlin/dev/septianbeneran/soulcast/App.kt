package dev.septianbeneran.soulcast

import androidx.compose.runtime.*
import dev.septianbeneran.soulcast.ui.screens.NotFoundScreen
import dev.septianbeneran.soulcast.ui.screens.PortfolioScreen
import dev.septianbeneran.soulcast.ui.theme.PortfolioTheme

@Composable
fun App() {
    val platform = remember { getPlatform() }
    val pathname = remember {
        try {
            platform.getPathname()
        } catch (e: Exception) {
            "/"
        }
    }

    val normalizedPath = pathname.trimEnd('/')
    val isHome = normalizedPath == "" ||
            normalizedPath == "/index.html" ||
            normalizedPath.endsWith("/index.html")

    LaunchedEffect(Unit) {
        platform.removeLoadingIndicator()
    }

    PortfolioTheme {
        if (isHome) {
            PortfolioScreen()
        } else {
            NotFoundScreen()
        }
    }
}