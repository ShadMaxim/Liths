package com.example.serenitysoul.navigation

import android.Manifest
import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
import com.example.serenitysoul.components.getTopBar
import com.example.serenitysoul.screens.AboutAppScreen
import com.example.serenitysoul.screens.ActionScreen
import com.example.serenitysoul.screens.MainScreen
import com.example.serenitysoul.screens.SettingsScreen
import com.example.serenitysoul.screens.SplashScreen
import com.example.serenitysoul.theme.SerenitySoulTheme
import com.example.serenitysoul.utils.Utils
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screen.getScreen(
        route = backStackEntry?.destination?.route ?: Screen.SplashScreen.route
    )

    val scrollTopBarBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        rememberTopAppBarState()
    )
    val topBar = remember { mutableStateOf<@Composable () -> Unit>(@Composable {}) }

    topBar.value = getTopBar(
        currentRoute = currentScreen,
        scrollTopBarBehavior = scrollTopBarBehavior/*,
        navController = navController,
        modifier = modifier,
        title = topBarTitle.value,
        scrollTopBarBehavior = scrollTopBarBehavior,
        onNavigateToProfile = {},
        onNavigateToSettings = {}*/
    )

    Scaffold(
        topBar = {
            topBar.value.invoke()
        }
    ) { innerPadding ->
        /*AppBar(
            selectedScreen = currentScreen,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() }
        )*/
        /*PermissionInformationAppBar(
            selectedScreen = currentScreen,
        )*/


        val inP = innerPadding

        /*val color = remember { Animatable(Color.Gray) }
        LaunchedEffect(Unit) {
            color.animateTo(Color.Red, animationSpec = tween(1000))
            color.animateTo(Color.Gray, animationSpec = tween(1000))
        }*/


        NavHost(
            navController = navController,
            startDestination = Screen.SplashScreen.route,
            modifier = Modifier
                .padding(innerPadding)
                /*.paint(
                    painter = painterResource(id = R.drawable.ic_back_start_screen),
                    contentScale = ContentScale.FillBounds
                )*/
                //.background(color = color.value)
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
                        //cancelAllAndNavigateToStart(navController)
                        navController.navigateUp()
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

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun AppBar(
    selectedScreen: Screen,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
) {

    val permissionStates = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    )

    var h = 30.dp

    if (permissionStates.allPermissionsGranted) {
        Text("Camera and Read storage permissions Granted! Thank you!")
    } else {
        h= 30.dp
        Column(
            modifier = Modifier.background(color = SerenitySoulTheme.colorScheme.red)
        ) {
            Text(
                Utils.getTextToShowGivenPermissions(
                    permissionStates.revokedPermissions,
                    permissionStates.shouldShowRationale
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { permissionStates.launchMultiplePermissionRequest() }) {
                Text("Request permissions")
            }
        }
    }

    //val heightTopBar = if (selectedScreen == Screen.SplashScreen) 0.dp else 10.dp
    val heightTopBar =
        when {
            selectedScreen == Screen.SplashScreen -> 0.dp
            permissionStates.allPermissionsGranted -> 10.dp
            else -> {50.dp}
        }
    //val heightTopBar = h

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

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionInformationAppBar(
    selectedScreen: Screen,
    /*modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},*/
) {

    val permissionStates = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    )

    if (permissionStates.allPermissionsGranted) {
        Text("Camera and Read storage permissions Granted! Thank you!")
    } else if (selectedScreen != Screen.SplashScreen) {

        Column(
            modifier = Modifier.background(color = SerenitySoulTheme.colorScheme.red)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                Utils.getTextToShowGivenPermissions(
                    permissionStates.revokedPermissions,
                    permissionStates.shouldShowRationale
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { permissionStates.launchMultiplePermissionRequest() }) {
                Text("Request permissions")
            }
        }
    }
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