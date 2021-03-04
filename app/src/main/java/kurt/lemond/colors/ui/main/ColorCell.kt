package kurt.lemond.colors.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kurt.lemond.colors.data.ColorInfo
import kurt.lemond.colors.data.createColorInfo
import kurt.lemond.colors.ui.theme.ColorsAppTheme

@Composable
fun ColorCell(
    colorInfo: ColorInfo,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp,
        modifier = modifier.height(180.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .weight(0.7f)
                    .fillMaxWidth()
                    .padding(
                        start = 15.dp,
                        end = 15.dp,
                        top = 15.dp,
                        bottom = 10.dp
                    )
                    .background(
                        shape = MaterialTheme.shapes.small,
                        color = colorInfo.color,
                    )
            )
            Text(
                text = colorInfo.rgb,
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.padding(
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 10.dp
                )
            )
        }
    }
}

@Preview("ColorCell")
@Composable
private fun ColorCellPreview() {
    ColorsAppTheme {
        ColorCell(
            colorInfo = createColorInfo()
        )
    }
}

@Preview("ColorCell - Dark")
@Composable
private fun ColorCellPreviewDark() {
    ColorsAppTheme(darkTheme = true) {
        ColorCell(
            colorInfo = createColorInfo()
        )
    }
}