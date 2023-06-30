package com.example.serenitysoul.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.serenitysoul.R
import com.example.serenitysoul.screens.ActionScreen
import com.example.serenitysoul.screens.MainScreen
import com.example.serenitysoul.screens.SettingsScreen
import com.example.serenitysoul.screens.SplashScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screen.getScreen(
        route = backStackEntry?.destination?.route ?: Screen.MainScreen.route
    )

    Scaffold(
        topBar = {
            AppBar(
                selectedScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screen.SplashScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Screen.MainScreen.route) {
                MainScreen(
                    textId = Screen.MainScreen.titleResId,
                    onSettingsDestination = { str ->
                        val route = Screen.SettingsScreen.route
                        //navController.navigate("$route/$str")
                        //navController.navigate(route = Screen.SettingsScreen.route, argument("str", str))
                        navController.navigate(route)
                    },
                    onActionsDestination = {
                        navController.navigate(Screen.ActionsScreen.route)
                    },
                    onCancelButtonClicked = {
                        cancelAllAndNavigateToStart(navController)
                    }
                )
            }
            composable(route = Screen.SettingsScreen.route) { b ->
                val route = Screen.MainScreen.route
                val argument = b.arguments
                SettingsScreen(
                    textId = Screen.SettingsScreen.titleResId,
                    onNextButtonClicked = {  },
                    onCancelButtonClicked = { str->
                        cancelAllAndNavigateToStart(navController)
                    },
                    argument = argument!!
                )
            }
            composable(route = Screen.ActionsScreen.route) {
                ActionScreen(
                    textId = Screen.ActionsScreen.titleResId,
                    onNextButtonClicked = {  },
                    onCancelButtonClicked = { cancelAllAndNavigateToStart(navController) })
            }
            composable(route = Screen.SplashScreen.route) {
                SplashScreen(
                    onNavigateToMain = {
                        navController.navigate(route = Screen.MainScreen.route) {
                            popUpTo(route = Screen.SplashScreen.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun AppBar(
    selectedScreen: Screen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(id = selectedScreen.titleResId)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

private fun cancelAllAndNavigateToStart(
    navController: NavHostController
) {
    navController.popBackStack(
        route = Screen.MainScreen.route,
        inclusive = false
    )
}