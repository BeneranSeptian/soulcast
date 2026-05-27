package dev.septianbeneran.soulcast.data

data class Project(
    val name: String,
    val description: String,
    val techStack: List<String>,
    val githubUrl: String? = null,
    val liveUrl: String? = null
)

val projects = listOf(
    Project(
        name = "Wondr by BNI",
        description = "A comprehensive digital banking app featuring QRIS payments, bill settlements, multi-currency transfers, and investment tracking. Built with a modular architecture supporting millions of active users.",
        techStack = listOf("Kotlin", "Jetpack Compose", "Hilt", "Retrofit", "Room"),
        liveUrl = "https://play.google.com/store/apps/details?id=id.co.bni.wondr"
    ),
    Project(
        name = "SmartCourier",
        description = "Logistics and delivery management app with real-time GPS tracking, route optimization, and proof-of-delivery capture. Integrated with Google Maps API for efficient fleet management.",
        techStack = listOf("React Native", "Google Maps", "Firebase", "TypeScript"),
        githubUrl = "https://github.com/BeneranSeptian"
    ),
    Project(
        name = "Soulcast",
        description = "A Kotlin Multiplatform portfolio template showcasing Compose Multiplatform for web. Features responsive design, smooth animations, and a clean dark theme.",
        techStack = listOf("Kotlin", "Compose Multiplatform", "KMP"),
        githubUrl = "https://github.com/BeneranSeptian/Soulcast"
    ),
    Project(
        name = "Agen Pegadaian Syariah",
        description = "Mobile companion app for Pegadaian Syariah agents to manage transactions, customer data, and inventory. Integrated with MoEngage for push notification campaigns.",
        techStack = listOf("Kotlin", "Android SDK", "MoEngage", "Firebase")
    )
)
