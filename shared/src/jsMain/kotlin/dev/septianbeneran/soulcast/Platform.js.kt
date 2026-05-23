package dev.septianbeneran.soulcast

import kotlinx.browser.window
import web.navigator.navigator

class JsPlatform: Platform {
    private val userAgent = navigator.userAgent
    private val browserList = listOf("Chrome", "Firefox", "Safari", "Edge")

    override val name: String = userAgent.findAnyOf(browserList, ignoreCase = true)
            ?.let { (startIndex) -> userAgent.substring(startIndex).substringBefore(" ") }
            ?: "Unknown"

    override fun getPathname(): String = window.location.pathname
    override fun removeLoadingIndicator() {
        window.document.getElementById("loading")?.remove()
    }
}

actual fun getPlatform(): Platform = JsPlatform()