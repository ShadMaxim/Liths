package com.example.serenitysoul.components

import android.Manifest
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.serenitysoul.navigation.Screen
import com.example.serenitysoul.theme.SerenitySoulTheme
import com.example.serenitysoul.utils.Utils
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun getTopBar(
    currentRoute: Screen,
    scrollTopBarBehavior: TopAppBarScrollBehavior? = null,
    onNavigateToSettings: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {},
    /*,
        navController: NavHostController,
        modifier: Modifier = Modifier,
        title: String = "Главная",
        scrollTopBarBehavior: TopAppBarScrollBehavior? = null,
        onNavigateToSettings: () -> Unit = {},
        onNavigateToProfile: () -> Unit = {},*/
): @Composable () -> Unit {

    val permissionStates = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    )

    return when {
        currentRoute == Screen.SplashScreen -> {
            {}
        }

        permissionStates.allPermissionsGranted -> {
            {}
        }

        else -> {
            {
                PermissionInformationTopBar(
                    scrollTopBarBehavior = scrollTopBarBehavior,
                    permissionStates = permissionStates,
                    onNavigateToSettings = onNavigateToSettings,
                    onNavigateToProfile = onNavigateToProfile,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
private fun PermissionInformationTopBar(
    scrollTopBarBehavior: TopAppBarScrollBehavior? = null,
    permissionStates: MultiplePermissionsState,
    onNavigateToSettings: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {},
) {
    TopAppBar(
        scrollBehavior = scrollTopBarBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = SerenitySoulTheme.colorScheme.red,
            scrolledContainerColor = SerenitySoulTheme.colorScheme.red
        ),
        title = {},
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(start = 4.dp, end = 10.dp),
            ) {
                /*Column(
                    modifier = Modifier.background(color = SerenitySoulTheme.colorScheme.red)
                ) {*/
                //Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = Utils.getTextToShowGivenPermissions(
                        permissionStates.revokedPermissions,
                        permissionStates.shouldShowRationale
                    ),
                    modifier = Modifier.weight(1f)

                )
                //Spacer(modifier = Modifier.height(8.dp))
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = { permissionStates.launchMultiplePermissionRequest() }) {
                    Text("Request permissions")
                }
                //}
            }

        }
    )
}

/*
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String = "Главная",
    scrollTopBarBehavior: TopAppBarScrollBehavior? = null,
    onNavigateToSettings: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {},
) {
    setStatusBarColor()
    TopAppBar(
        scrollBehavior = scrollTopBarBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = VtbTheme.colorScheme.statusBarBackgroundColor,
            scrolledContainerColor = VtbTheme.colorScheme.statusBarBackgroundColor
        ),
        title = {},
        actions = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(color = VtbTheme.colorScheme.statusBarBackgroundColor)
                    .padding(start = 4.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clickable { onNavigateToSettings.invoke() }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_page_settings),
                        contentDescription = null,
                        tint = neutralGreySilver,
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = title,
                    style = VtbTheme.typography.Medium_18.copy(color = VtbTheme.colorScheme.primaryContent),
                    modifier = Modifier
                        .weight(1f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                CoilImageLoader(
                    imageUri = "https://media.licdn.com/dms/image/C5603AQGz0GuEKmxeaw/profile-displayphoto-shrink_200_200/0/1532431602373?e=1694649600&v=beta&t=c4AybKsCS687VW3CxakpSlM1yXLO5HG7Z17oZ5xaZSs",
                    modifier = modifier
                        .size(44.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { onNavigateToProfile.invoke() },
                    failure = {
                        Image(
                            painter = painterResource(id = com.alseda.components.R.drawable.ic_not_product),
                            contentDescription = null
                        )
                    }
                )
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DefaultTopBar(
    modifier: Modifier = Modifier,
    title: String = "Главная",
    navController: NavHostController? = null,
    topBarColor: Color = VtbTheme.colorScheme.statusBarBackgroundColor
) {
    setStatusBarColor(
        darkColor = topBarColor,
        lightColor = topBarColor
    )
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = topBarColor,
            scrolledContainerColor = topBarColor
        ),
        title = {},
        actions = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(color = topBarColor)
                    .padding(start = 4.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clickable { navController?.popBackStack() }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back_arrow),
                        contentDescription = null,
                        tint = neutralGreySilver,
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = title,
                    style = VtbTheme.typography.Medium_18.copy(color = VtbTheme.colorScheme.primaryContent),
                    modifier = Modifier
                        .wrapContentSize(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        })
}*/
