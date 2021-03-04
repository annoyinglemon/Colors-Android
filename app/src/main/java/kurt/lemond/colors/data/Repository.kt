package kurt.lemond.colors.data

import androidx.compose.ui.graphics.Color
import kotlin.random.Random


fun createColorInfoList(count: Int = 100): List<ColorInfo> {
    return (0 until count).map {
        createColorInfo()
    }
}

fun createColorInfo(): ColorInfo = Random.Default.run {
    val red = this.nextInt(256)
    val green = this.nextInt(256)
    val blue = this.nextInt(256)

    ColorInfo(
        color = Color(red, green, blue),
        rgb = "rgb($red, $green, $blue)"
    )
}