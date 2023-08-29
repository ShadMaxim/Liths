@file:OptIn(ExperimentalPermissionsApi::class)

package com.example.serenitysoul.screens

import android.os.Bundle
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.serenitysoul.R
import com.example.serenitysoul.navigation.Screen
import com.example.serenitysoul.theme.SerenitySoulTheme
import com.example.serenitysoul.utils.helpers.PreferencesDataStoreHelper
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.junit.Test

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun SettingsScreen(
    textId: Int,
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: (String) -> Unit,
    onShowAboutScreen: () -> Unit,
    modifier: Modifier = Modifier,
    showState: MutableState<Boolean>,
    //bottomSheetState: SheetState,
    dragHandle: @Composable (() -> Unit),
    content: @Composable ColumnScope.() -> Unit,
    argument: Bundle
) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val s = argument.getString("")

    val context = LocalContext.current
    val dataStore by remember { mutableStateOf(PreferencesDataStoreHelper(context)) }
    val scope = rememberCoroutineScope()
    val tokenFromDataSore = dataStore.getFromDataStore(stringPreferencesKey("QQQ"), "0").collectAsState(
        initial = ""
    )


    /*val permissionState = rememberPermissionState(
        permission = READ_EXTERNAL_STORAGE
    )
    val permissionStates = rememberMultiplePermissionsState(
        permissions = listOf(
            READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE
        )
    )*/

    if (showState.value) {
        ModalBottomSheet(
            modifier = Modifier/*.systemBarsPadding()*/,
            onDismissRequest = { showState.value = false },
            sheetState = bottomSheetState,
            //scrimColor = VtbTheme.colorScheme.scrim,
            //containerColor = VtbTheme.colorScheme.background,
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            tonalElevation = 0.dp,
            dragHandle = dragHandle,
        ) {
            content()
            Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.systemBars))
        }
    }
    Column(
        modifier = Modifier
            .background(color = SerenitySoulTheme.colorScheme.settingsBackgroundColor)
    ) {
        //Spacer(modifier = Modifier.size(20.dp))
        Text(text = stringResource(id = textId))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                showState.value = true
            }
        ) {
            Text(stringResource(R.string.show_list))
        }

        OutlinedButton(
            modifier = Modifier.weight(1f),
            onClick = {
                scope.launch {
                    val newData = tokenFromDataSore.value.toInt().inc()
                    dataStore.putToDataStore(
                        stringPreferencesKey("QQQ"),
                        newData.toString()
                    )
                }
            }
        ) {
            Text((tokenFromDataSore.value))
        }
        //start
        /*if (permissionState.status.isGranted) {
            Text("Camera permission Granted")
        } else {
            Column {
                val textToShow = if (permissionState.status.shouldShowRationale) {
                    // If the user has denied the permission but the rationale can be shown,
                    // then gently explain why the app requires this permission
                    "The camera is important for this app. Please grant the permission."
                } else {
                    // If it's the first time the user lands on this feature, or the user
                    // doesn't want to be asked again for this permission, explain that the
                    // permission is required
                    "Camera permission required for this feature to be available. " +
                            "Please grant the permission"
                }
                Text(textToShow)
                Button(onClick = { permissionState.launchPermissionRequest() }) {
                    Text("Request permission")
                }
            }
        }*/

        /*if (permissionStates.allPermissionsGranted) {
            Text("Camera and Read storage permissions Granted! Thank you!")
        } else {
            Column {
                Text(
                    getTextToShowGivenPermissions(
                        permissionStates.revokedPermissions,
                        permissionStates.shouldShowRationale
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { permissionStates.launchMultiplePermissionRequest() }) {
                    Text("Request permissions")
                }
            }
        }*/
        //end
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
                .weight(1f, false),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ) {
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = {
                    onCancelButtonClicked.invoke("987")
                    /*scope.launch {
                        dataStore.putToDataStore(
                            stringPreferencesKey("QQQ"),
                            "1234567890"
                        )
                    }*/
                }
            ) {
                Text(stringResource(R.string.cancel))
            }
            Button(
                modifier = Modifier.weight(1f),
                // the button is enabled when the user makes a selection
                //enabled = selectedValue.isNotEmpty(),
                onClick = {
                    onNextButtonClicked.invoke()
                    /*scope.launch {
                        val fl = dataStore.getFromDataStore(
                            stringPreferencesKey("QQQ"),
                            "0000"
                        ).collect()
                    }*/
                }
            ) {
                Text(stringResource(R.string.about_app))
            }
        }
    }

    /*LaunchedEffect(permissionStates.allPermissionsGranted) {
        if (!permissionStates.allPermissionsGranted)
            showState.value = true
    }*/
}

@Preview(
    showBackground = false, backgroundColor = 0xFF606981,
    device = "spec:parent=pixel_5", showSystemUi = true
)
@Composable
fun previewSettingsScreen() {
    val showCardInfoState = remember {
        mutableStateOf(false)
    }
    SettingsScreen(
        textId = Screen.SettingsScreen.titleResId,
        onNextButtonClicked = {},
        onCancelButtonClicked = {},
        onShowAboutScreen = {},
        showState = showCardInfoState,
        argument = Bundle(),
        dragHandle = {},
        content = {}

    )
}

/*
@OptIn(ExperimentalPermissionsApi::class)
private fun getTextToShowGivenPermissions(
    permissions: List<PermissionState>,
    shouldShowRationale: Boolean
): String {
    val revokedPermissionsSize = permissions.size
    if (revokedPermissionsSize == 0) return ""

    val textToShow = StringBuilder().apply {
        append("The ")
    }

    for (i in permissions.indices) {
        textToShow.append(permissions[i].permission)
        when {
            revokedPermissionsSize > 1 && i == revokedPermissionsSize - 2 -> {
                textToShow.append(", and ")
            }
            i == revokedPermissionsSize - 1 -> {
                textToShow.append(" ")
            }
            else -> {
                textToShow.append(", ")
            }
        }
    }
    textToShow.append(if (revokedPermissionsSize == 1) "permission is" else "permissions are")
    textToShow.append(
        if (shouldShowRationale) {
            " important. Please grant all of them for the app to function properly."
        } else {
            " denied. The app cannot function without them."
        }
    )
    return textToShow.toString()
}*/