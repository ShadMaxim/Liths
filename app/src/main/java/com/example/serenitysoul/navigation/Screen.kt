package com.example.serenitysoul.navigation

import androidx.annotation.StringRes
import com.example.serenitysoul.R

sealed class Screen(
    val route: String,
    @StringRes var titleResId: Int,
    var title: String? = null,
    val parameterKey: String? = null
) {
    object SplashScreen : Screen("splash", R.string.splash)
    object MainScreen : Screen("main", R.string.main)
    object SettingsScreen : Screen("settings", R.string.settings)
    object AboutAppScreen : Screen("about", R.string.about_app)
    object ActionsScreen : Screen("actions", R.string.actions)

    companion object {
        fun getScreen(route: String): Screen {
            return Screen::class.sealedSubclasses.firstOrNull { route?.contains(it.objectInstance?.route.orEmpty()) == true }?.objectInstance ?: SplashScreen
        }
    }
}
