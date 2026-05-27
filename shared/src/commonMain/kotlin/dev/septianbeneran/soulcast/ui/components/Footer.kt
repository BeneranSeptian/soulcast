package dev.septianbeneran.soulcast.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.Instagram
import compose.icons.fontawesomeicons.brands.Linkedin
import compose.icons.fontawesomeicons.regular.Envelope

@Composable
fun Footer() {
    val uriHandler = LocalUriHandler.current
    val primaryColor = MaterialTheme.colorScheme.primary
    val surfaceColor = MaterialTheme.colorScheme.surface
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OrnamentDivider(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .padding(bottom = 24.dp)
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val socialLinks = listOf(
                FontAwesomeIcons.Brands.Github to "https://github.com/BeneranSeptian",
                FontAwesomeIcons.Brands.Linkedin to "https://www.linkedin.com/in/seftian-nurfaozy/",
                FontAwesomeIcons.Brands.Instagram to "https://www.instagram.com/septianbeneran/",
                FontAwesomeIcons.Regular.Envelope to "mailto:m.septiann@gmail.com"
            )
            socialLinks.forEach { (icon, url) ->
                IconButton(
                    onClick = { uriHandler.openUri(url) },
                    modifier = Modifier.size(44.dp),
                    colors = IconButtonDefaults.iconButtonColors(containerColor = surfaceColor)
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = onSurfaceColor.copy(alpha = 0.4f)
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Built with Compose Multiplatform",
            style = MaterialTheme.typography.bodySmall.copy(
                color = onSurfaceColor.copy(alpha = 0.3f),
                fontWeight = FontWeight.Normal,
                letterSpacing = 1.sp
            )
        )
    }
}
