package kurt.lemond.colors.ui.main

import androidx.compose.animation.*
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.unit.dp

private val IconSize = 30.dp
private const val AnimationDuration = 300

@ExperimentalAnimationApi
@Composable
fun ThemeToggleFAB(
    isDarkTheme: Boolean,
    onThemeClick: () -> Unit,
    modifier: Modifier
) {
    FloatingActionButton(
        onClick = onThemeClick,
        modifier = modifier,
    ) {
        AnimatedVisibility(
            visible = isDarkTheme,
            enter =  slideInVertically(
                animationSpec = tween(AnimationDuration)
            ) + fadeIn(), // slide in from top
            exit = slideOutVertically(
                animationSpec = tween(AnimationDuration)
            ) + fadeOut() // slide out to top
        ) {
            Icon(
                imageVector = Icons.Outlined.DarkMode,
                contentDescription = "dark mode",
                tint = MaterialTheme.colors.onSurface,
                modifier = Modifier.size(IconSize)
            )
        }
        AnimatedVisibility(
            visible = !isDarkTheme,
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> fullHeight / 2 },
                animationSpec = tween(AnimationDuration)
            ) + fadeIn(), // slide in from bottom
            exit = slideOutVertically(
                targetOffsetY = { fullHeight -> fullHeight / 2 },
                animationSpec = tween(AnimationDuration)
            ) + fadeOut() // slide out to bottom
        ) {
            Icon(
                imageVector = Icons.Outlined.WbSunny,
                contentDescription = "light mode",
                tint = MaterialTheme.colors.onSurface,
                modifier = Modifier.size(IconSize)
            )
        }
    }
}