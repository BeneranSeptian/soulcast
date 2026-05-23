package dev.septianbeneran.soulcast.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.Instagram
import compose.icons.fontawesomeicons.brands.Linkedin
import compose.icons.fontawesomeicons.regular.Envelope
import dev.septianbeneran.soulcast.ui.theme.NeonGreen
import dev.septianbeneran.soulcast.ui.theme.TextSecondary

@Composable
fun Footer() {
    val uriHandler = LocalUriHandler.current
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(0.1f)
                .padding(bottom = 32.dp),
            color = NeonGreen.copy(alpha = 0.3f),
            thickness = 2.dp
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ContactButton(
                icon = FontAwesomeIcons.Brands.Github,
                contentDescription = "GitHub",
                onClick = { uriHandler.openUri("https://github.com/BeneranSeptian") }
            )
            ContactButton(
                icon = FontAwesomeIcons.Brands.Linkedin,
                contentDescription = "LinkedIn",
                onClick = { uriHandler.openUri("https://www.linkedin.com/in/seftian-nurfaozy/") }
            )
            ContactButton(
                icon = FontAwesomeIcons.Brands.Instagram,
                contentDescription = "Instagram",
                onClick = { uriHandler.openUri("https://www.instagram.com/septianbeneran/") }
            )
            ContactButton(
                icon = FontAwesomeIcons.Regular.Envelope,
                contentDescription = "Email",
                onClick = { uriHandler.openUri("mailto:m.septiann@gmail.com") }
            )
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Text(
            text = "Built with Compose Multiplatform.",
            style = MaterialTheme.typography.bodySmall.copy(
                color = TextSecondary,
                fontWeight = FontWeight.Medium
            )
        )
    }
}
