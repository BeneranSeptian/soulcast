package dev.septianbeneran.soulcast.data

data class WorkExperience(
    val company: String,
    val position: String,
    val duration: String,
    val description: String
)

val experiences = listOf(
    WorkExperience(
        position = "Android Developer",
        company = "PT. Bank Negara Indonesia",
        duration = "Nov 2023 – Feb 2026",
        description = "Developed features for the 'Wondr by BNI' app, including QRIS, bill payment, transfers, and multi-currency support using Kotlin and Jetpack Compose."
    ),
    WorkExperience(
        position = "Front End Mobile Developer",
        company = "PT. Reycom Document Solusi",
        duration = "Sep 2022 – Nov 2023",
        description = "Developed cross-platform mobile applications using React Native, including SmartCourier with Google Maps integration and a Record Management System with RFID and barcode scanner support."
    ),
    WorkExperience(
        position = "Android Developer Internship",
        company = "PT. Pegadaian",
        duration = "Apr 2022 – Aug 2022",
        description = "Worked on the Agen Pegadaian Syariah app by implementing new features, fixing bugs, and integrating MoEngage services."
    )
)
