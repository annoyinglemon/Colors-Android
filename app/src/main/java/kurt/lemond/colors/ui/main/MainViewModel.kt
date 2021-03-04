package kurt.lemond.colors.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kurt.lemond.colors.data.createColorInfoList

class MainViewModel: ViewModel() {

    // used for overriding isSystemInDarkTheme() on MainActivity upon setContent recomposition
    var themeToggled: Boolean = false

    var colorInfos by mutableStateOf(createColorInfoList(51))
        private set

    var isDarkTheme by mutableStateOf(false)
        private set


    fun toggleTheme() {
        toggleTheme(!this.isDarkTheme)
    }

    fun toggleTheme(isDarkTheme: Boolean) {
        this.isDarkTheme = isDarkTheme
        themeToggled = true
    }

}