package dev.septianbeneran.soulcast

interface Platform {
    val name: String
    fun getPathname(): String
    fun removeLoadingIndicator()
}

expect fun getPlatform(): Platform