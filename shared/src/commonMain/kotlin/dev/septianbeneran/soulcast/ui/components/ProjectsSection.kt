package dev.septianbeneran.soulcast.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.septianbeneran.soulcast.data.projects

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectsSection(isMobile: Boolean) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (isMobile) Alignment.CenterHorizontally else Alignment.Start
    ) {
        Text(
            text = "Projects",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
        Spacer(modifier = Modifier.height(40.dp))
        projects.forEach { project ->
            ProjectItem(project, isMobile)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
