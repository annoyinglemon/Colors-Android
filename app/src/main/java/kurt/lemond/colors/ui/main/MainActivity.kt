package kurt.lemond.colors.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import kurt.lemond.colors.ui.theme.ColorsAppTheme


@ExperimentalAnimationApi
@ExperimentalFoundationApi
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            if (isSystemInDarkTheme() && !mainViewModel.themeToggled) {
                mainViewModel.toggleTheme(true)
            }

            ColorsAppTheme(darkTheme = mainViewModel.isDarkTheme) {
                MainActivityContent(
                    isDarkTheme = mainViewModel.isDarkTheme,
                    toggleThemeClick = { mainViewModel.toggleTheme() },
                    colors = mainViewModel.colorInfos
                )
            }
        }
    }
}

