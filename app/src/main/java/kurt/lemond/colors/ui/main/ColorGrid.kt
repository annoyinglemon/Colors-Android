package kurt.lemond.colors.ui.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kurt.lemond.colors.data.ColorInfo


@ExperimentalFoundationApi
@Composable
fun ColorsGrid(
    colors: List<ColorInfo>,
    listState: LazyListState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.background(color = MaterialTheme.colors.background)
    ) {
        val columnCount = 2
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(MinHeaderHeight)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(columnCount),
            contentPadding = PaddingValues(
                top = MaxHeaderHeight - MinHeaderHeight,
                bottom = 12.dp
            ),
            state = listState
        ) {
            items(colors.size) { index ->
                ColorCell(
                    colorInfo = colors[index],
                    modifier = Modifier.padding(
                        start = if (index % columnCount == 0) 24.dp else 12.dp,
                        end = if (index % columnCount == 1) 24.dp else 12.dp,
                        top = if (index >= columnCount) 12.dp else 4.dp,
                        bottom = 12.dp
                    )
                )
            }
        }
    }
}