package dev.septianbeneran.soulcast.data

import org.jetbrains.compose.resources.DrawableResource
import soulcast.shared.generated.resources.Res
import soulcast.shared.generated.resources.wondr_logo
import soulcast.shared.generated.resources.smartcourier_logo
import soulcast.shared.generated.resources.mirecruit_logo
import soulcast.shared.generated.resources.rms_logo
import soulcast.shared.generated.resources.pegadaian_logo

data class Project(
    val name: String,
    val description: String,
    val techStack: List<String>,
    val githubUrl: String? = null,
    val liveUrl: String? = null,
    val logoRes: DrawableResource? = null
)

val projects = listOf(
    Project(
        name = "wondr by BNI",
        description = "A comprehensive digital banking app featuring QRIS payments, bill settlements, multi-currency transfers, and investment tracking. Built with a modular architecture supporting millions of active users.",
        techStack = listOf("Kotlin", "Jetpack Compose", "Hilt", "Retrofit", "Coroutines", "Multi Module", "Multi Repo"),
        liveUrl = "https://play.google.com/store/apps/details?id=id.bni.wondr",
        logoRes = Res.drawable.wondr_logo
    ),
    Project(
        name = "SmartCourier",
        description = "Logistics and delivery management app with real-time GPS tracking, route optimization, and proof-of-delivery capture. Integrated with Google Maps API for efficient fleet management.",
        techStack = listOf("React Native", "Typescript", "Javascript", "Google Maps", "Firebase"),
        liveUrl = "https://play.google.com/store/apps/details?id=com.smartcourier",
        logoRes = Res.drawable.smartcourier_logo
    ),
    Project(
        name = "MiRecruit",
        description = "Recruitment platform for Manulife agents available on Android and iOS. Used by recruiters to onboard and manage prospective insurance agents with streamlined application and tracking workflows.",
        techStack = listOf("React Native", "Typescript", "Javascript", "Android", "iOS", "Firebase"),
        liveUrl = "https://play.google.com/store/apps/details?id=com.manulife",
        logoRes = Res.drawable.mirecruit_logo
    ),
    Project(
        name = "RMS (Record Management System)",
        description = "Internal warehouse management app used by staff to organize and track document boxes on CipherLab devices. Developed custom libraries to integrate RFID and barcode scanner functionality directly into the hardware workflow.",
        techStack = listOf("React Native","Typescript", "Android SDK", "RFID", "Barcode Scanner", "CipherLab"),
        logoRes = Res.drawable.rms_logo
    ),
    Project(
        name = "Agen Pegadaian Syariah",
        description = "Mobile companion app for Pegadaian Syariah agents to manage transactions, customer data, and inventory. Integrated with MoEngage for push notification campaigns.",
        techStack = listOf("Java", "Android SDK", "MoEngage"),
        liveUrl = "https://play.google.com/store/apps/details?id=co.pegadaian.syariah.agen",
        logoRes = Res.drawable.pegadaian_logo
    ),
    Project(
        name = "Soulcast",
        description = "A Kotlin Multiplatform portfolio template showcasing Compose Multiplatform for web. Features responsive design, smooth animations, and a clean dark theme. You are looking at it!",
        techStack = listOf("Kotlin", "Compose Multiplatform", "KMP"),
        githubUrl = "https://github.com/BeneranSeptian/Soulcast"
    )
)
