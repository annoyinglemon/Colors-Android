package kurt.lemond.colors.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import kurt.lemond.colors.ui.theme.ColorsAppTheme

val MinHeaderHeight = 56.dp
val MaxHeaderHeight = 180.dp

private val MaxTitleFontSize = 48.sp
private val MinTitleFontSize = 24.sp

@ExperimentalAnimationApi
@Composable
fun Header(
    listState: LazyListState,
    isDarkTheme: Boolean,
    onThemeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var headerHeight by remember { mutableStateOf(MaxHeaderHeight) }
    var titleFontSize by remember { mutableStateOf(MaxTitleFontSize) }

    if (listState.firstVisibleItemIndex == 0) {
        val collapseRange = LocalDensity.current.run {
            (MaxHeaderHeight - MinHeaderHeight).toPx()
        }
        val collapseFraction = (listState.firstVisibleItemScrollOffset / collapseRange).coerceIn(0f, 1f)

        headerHeight = lerp(MaxHeaderHeight, MinHeaderHeight, collapseFraction)
        titleFontSize = lerp(MaxTitleFontSize, MinTitleFontSize, collapseFraction)
    }

    Surface(
        elevation = if (headerHeight == MinHeaderHeight) 6.dp else 0.dp,
        modifier = modifier
            .fillMaxWidth()
            .height(headerHeight)
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            Text(
                text = "Colors",
                style = TextStyle(
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Bold,
                    fontSize = titleFontSize,
                    fontFamily = MaterialTheme.typography.h4.fontFamily
                ),
                modifier = Modifier.align(Alignment.BottomStart)
            )
            ThemeToggleFAB(
                isDarkTheme = isDarkTheme,
                onThemeClick = onThemeClick,
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }
    }
}

@ExperimentalAnimationApi
@Preview("Header")
@Composable
fun HeaderPreview() {
    ColorsAppTheme {
        Surface(modifier = Modifier.fillMaxWidth()) {
            Header(
                isDarkTheme = false,
                listState = LazyListState(),
                onThemeClick = {})
        }
    }
}

@ExperimentalAnimationApi
@Preview("Header | Collapsed")
@Composable
fun HeaderPreviewCollapsed() {
    ColorsAppTheme {
        Surface(modifier = Modifier.fillMaxWidth()) {
            Header(
                isDarkTheme = false,
                listState = LazyListState(firstVisibleItemScrollOffset = 500),
                onThemeClick = {}
            )
        }
    }
}

@ExperimentalAnimationApi
@Preview("Header - Dark")
@Composable
fun HeaderPreviewDark() {
    ColorsAppTheme(darkTheme = true) {
        Surface(modifier = Modifier.fillMaxWidth()) {
            Header(
                isDarkTheme = true,
                listState = LazyListState(),
                onThemeClick = {}
            )
        }
    }
}

@ExperimentalAnimationApi
@Preview("Header - Dark | Collapsed")
@Composable
fun HeaderPreviewDarkCollapsed() {
    ColorsAppTheme(darkTheme = true) {
        Surface(modifier = Modifier.fillMaxWidth()) {
            Header(
                isDarkTheme = true,
                listState = LazyListState(firstVisibleItemScrollOffset = 500),
                onThemeClick = {}
            )
        }
    }
}