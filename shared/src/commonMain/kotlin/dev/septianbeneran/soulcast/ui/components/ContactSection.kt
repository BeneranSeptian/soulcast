package dev.septianbeneran.soulcast.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
fun ContactSection() {
    val uriHandler = LocalUriHandler.current
    val primaryColor = MaterialTheme.colorScheme.primary
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface
    val surfaceColor = MaterialTheme.colorScheme.surface

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionHeader(title = "Contact")

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Have a project in mind or just want to say hi?\nI'm always open to new opportunities.",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = onSurfaceColor.copy(alpha = 0.7f),
                lineHeight = 24.sp
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(28.dp))

        OutlinedButton(
            onClick = { uriHandler.openUri("mailto:m.septiann@gmail.com") },
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(1.dp, primaryColor.copy(alpha = 0.4f)),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
        ) {
            Icon(
                imageVector = FontAwesomeIcons.Regular.Envelope,
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                tint = primaryColor
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Send an Email",
                color = primaryColor,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Or find me on",
            style = MaterialTheme.typography.bodySmall.copy(
                color = onSurfaceColor.copy(alpha = 0.3f),
                letterSpacing = 1.sp
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            val socialLinks = listOf(
                FontAwesomeIcons.Brands.Github to "https://github.com/BeneranSeptian",
                FontAwesomeIcons.Brands.Linkedin to "https://www.linkedin.com/in/seftian-nurfaozy/",
                FontAwesomeIcons.Brands.Instagram to "https://www.instagram.com/septianbeneran/"
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
    }
}
