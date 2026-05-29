# Soulcast — Developer Portfolio

A personal portfolio website built with **Kotlin Multiplatform** and **Compose Multiplatform**, compiled to WebAssembly (Wasm) and JavaScript for the browser.

## Features

- Single-page layout with smooth scroll navigation
- Responsive design (desktop & mobile)
- Theme color randomizer with 8 preset palettes
- Animated ambient background
- Experience timeline with progression line
- Project showcase with tech stack tags
- Dark theme with warm brass/amber accents

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Kotlin 2.3 |
| UI Framework | Compose Multiplatform 1.11 |
| Design System | Material 3 |
| Target | Kotlin/Wasm + Kotlin/JS |
| Build | Gradle (Kotlin DSL) |

## Project Structure

```
Soulcast/
├── shared/                    # Shared KMP module
│   └── src/commonMain/
│       ├── kotlin/.../
│       │   ├── App.kt             # Root composable & navigation
│       │   ├── Platform.kt        # Platform expect/actual
│       │   ├── data/              # Data models (Project, WorkExperience)
│       │   └── ui/
│       │       ├── components/    # Reusable composables
│       │       ├── screens/       # Page content composables
│       │       └── theme/         # Color palette & theme
│       └── composeResources/      # Images & resources
├── webApp/                    # Web application module
│   └── src/webMain/resources/
│       ├── index.html             # SEO meta tags & structured data
│       └── styles.css             # Base styles
└── gradle/
    └── libs.versions.toml         # Version catalog
```

## Running Locally

**Wasm target** (recommended, modern browsers):
```bash
./gradlew :webApp:wasmJsBrowserDevelopmentRun
```

**JS target** (fallback, older browser support):
```bash
./gradlew :webApp:jsBrowserDevelopmentRun
```

## Customization

### Change theme palettes

Edit `Theme.kt` — modify the `themePalettes` list with your own `ThemeColors` entries:

```kotlin
val themePalettes = listOf(
    ThemeColors(primary = Color(0xFFC4956A), glow = Color(0xFFE8B86D), secondary = Color(0xFFB87333)),
    // add more...
)
```

### Add project screenshots

Place images in `shared/src/commonMain/composeResources/drawable/` and reference them in `Project.kt`.

### Update content

- **Experience:** Edit `data/WorkExperience.kt`
- **Projects:** Edit `data/Project.kt`
- **Bio & skills:** Edit `ui/screens/HomeScreen.kt` and `ui/components/TechStackSection.kt`

## License

MIT
