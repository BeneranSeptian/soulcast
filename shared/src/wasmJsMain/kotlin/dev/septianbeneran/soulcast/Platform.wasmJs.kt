package dev.septianbeneran.soulcast

import kotlinx.browser.window

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
    override fun getPathname(): String = window.location.pathname
    override fun removeLoadingIndicator() {
        window.document.getElementById("loading")?.run {
            parentNode?.removeChild(this)
        }
    }
}

actual fun getPlatform(): Platform = WasmPlatform()