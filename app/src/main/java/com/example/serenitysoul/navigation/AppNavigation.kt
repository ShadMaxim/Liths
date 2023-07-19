package com.example.serenitysoul.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.serenitysoul.R
import com.example.serenitysoul.screens.AboutAppScreen
import com.example.serenitysoul.screens.ActionScreen
import com.example.serenitysoul.screens.MainScreen
import com.example.serenitysoul.screens.SettingsScreen
import com.example.serenitysoul.screens.SplashScreen
import com.example.serenitysoul.theme.SerenitySoulTheme

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screen.getScreen(
        route = backStackEntry?.destination?.route ?: Screen.SplashScreen.route
    )

    Scaffold(
        //можно вернуть, но надо разобраться с отступами верхними
        /*topBar = {
            AppBar(
                selectedScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }*/
    ) { innerPadding ->

        val inP = innerPadding

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
                //EnterAnimation {
                val showCardInfoState = remember {
                    mutableStateOf(false)
                }
                SettingsScreen(
                    textId = Screen.SettingsScreen.titleResId,
                    onNextButtonClicked = { navController.navigate(Screen.AboutAppScreen.route) },
                    onCancelButtonClicked = { str ->
                        cancelAllAndNavigateToStart(navController)
                    },
                    onShowAboutScreen = {
                        navController.navigate(Screen.AboutAppScreen.route)
                    },
                    argument = argument!!,
                    showState = showCardInfoState,
                    dragHandle = {
                        Text(
                            text = "1234",
                            style = SerenitySoulTheme.typography.Bold_24.copy(
                                color = SerenitySoulTheme.colorScheme.green
                            )
                        )
                    },
                    content = {
                        Text(text = "999999999")
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = "999999999")
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = "999999999")
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = "999999999")
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = "999999999")
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = "999999999")
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = "999999999")
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = "999999999")
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = "999999999")
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = "999999999")
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = "999999999")
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = "999999999")
                    }
                )
                //}
                /*SettingsScreen(
                    textId = Screen.SettingsScreen.titleResId,
                    onNextButtonClicked = { navController.navigate(Screen.AboutAppScreen.route) },
                    onCancelButtonClicked = { str ->
                        cancelAllAndNavigateToStart(navController)
                    },
                    onShowAboutScreen = {
                        navController.navigate(Screen.AboutAppScreen.route)
                    },
                    argument = argument!!
                )*/
            }
            composable(route = Screen.ActionsScreen.route) {
                ActionScreen(
                    textId = Screen.ActionsScreen.titleResId,
                    onNextButtonClicked = { },
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
            composable(route = Screen.AboutAppScreen.route) {
                AboutAppScreen(
                    textId = Screen.AboutAppScreen.titleResId,
                    onCancelButtonClicked = {
                        cancelAllAndNavigateToStart(navController)
                    }
                )
            }
        }
    }
}

/*@Composable
fun AppBar(
    selectedScreen: Screen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val heightTopBar = if (selectedScreen == Screen.SplashScreen) 0.dp else 80.dp
    TopAppBar(
        title = { Text(
            text = stringResource(id = selectedScreen.titleResId),
            textAlign = TextAlign.Center
        ) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier
            .height(heightTopBar),
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
}*/

@Composable
fun AppBar(
    selectedScreen: Screen,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
) {
    val heightTopBar = if (selectedScreen == Screen.SplashScreen) 0.dp else 10.dp

    TopAppBar(
        title = {
            Box(
                modifier = modifier
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = selectedScreen.titleResId),
                    textAlign = TextAlign.Center
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier
            .height(heightTopBar),
        navigationIcon = {
            Box(
                modifier = modifier
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                if (canNavigateBack) {
                    IconButton(
                        onClick = navigateUp,
                        //modifier = Modifier.(Alignment.CenterVertically)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button)
                        )
                    }
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

/*@OptIn(ExperimentalAnimationApi::class)
@Composable
fun EnterAnimation(content: @Composable () -> Unit) {
    AnimatedVisibility(
        visible = true,
        enter = slideInVertically(
            initialOffsetY = { -4000 }
        ) + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(initialAlpha = 9f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut(),
        content = content,
        initiallyVisible = false
    )
}*/

@Preview(showBackground = true, backgroundColor = 0xFF606981)
@Composable
fun previewAppBar() {
    AppBar(
        selectedScreen = Screen.MainScreen,
        canNavigateBack = true
    )
}