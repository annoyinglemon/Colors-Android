package kurt.lemond.colors.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import kurt.lemond.colors.data.ColorInfo


@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun MainActivityContent(
    isDarkTheme: Boolean,
    toggleThemeClick: () -> Unit,
    colors: List<ColorInfo>
) {
    /** y-offset, from 60dp to 0dp **/
    val dpTransState = remember {
        MutableTransitionState(initialState = 50).apply {
            targetState = 0
        }
    } // remember required by updateTransition
    val yOffsetTrans = updateTransition(transitionState = dpTransState)
    val yAnimateState = yOffsetTrans
        .animateDp(
            transitionSpec = { tween(600, 0) }
        ) { dpInt ->
            dpInt.dp
        }

    /** alpha, from 0f to 1f **/
    val floatTransState = remember {
        MutableTransitionState(initialState = 0f).apply {
            targetState = 1f
        }
    } // remember required by updateTransition
    val alphaTrans = updateTransition(transitionState = floatTransState)
    val alphaAnimateState = alphaTrans
        .animateFloat(
            transitionSpec = { tween(600, 0) }
        ) { alphaFloat ->
            alphaFloat
        }

    Box(modifier = Modifier.fillMaxSize()) {
        val listState = remember { LazyListState() }
        ColorsGrid(
            colors = colors,
            listState = listState,
            modifier = Modifier
                .alpha(alphaAnimateState.value)
                .absoluteOffset(
                    y = yAnimateState.value
                )
        )
        Header(
            listState = listState,
            isDarkTheme = isDarkTheme,
            onThemeClick = toggleThemeClick,
            modifier = Modifier
                .alpha(alphaAnimateState.value)
                .absoluteOffset(
                    y = -(yAnimateState.value)
                )
        )
    }
}
