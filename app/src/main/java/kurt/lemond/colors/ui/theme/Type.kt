package kurt.lemond.colors.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kurt.lemond.colors.R

private val kanit = FontFamily(
        Font(R.font.kanit_regular),
        Font(R.font.kanit_light, FontWeight.Light),
        Font(R.font.kanit_bold, FontWeight.Bold)
)

val ColorsAppTypography = Typography(
        h4 = TextStyle(
                fontFamily = kanit,
                fontWeight = FontWeight.Bold,
                fontSize = 34.sp
        ),
        h5 = TextStyle(
                fontFamily = kanit,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
        ),
        h6 = TextStyle(
                fontFamily = kanit,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
        ),
        subtitle1 = TextStyle(
                fontFamily = kanit,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
        ),
        subtitle2 = TextStyle(
                fontFamily = kanit,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
        ),
        body1 = TextStyle(
                fontFamily = kanit,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
        ),
        body2 = TextStyle(
                fontFamily = kanit,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
        ),
        button = TextStyle(
                fontFamily = kanit,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
        )
)