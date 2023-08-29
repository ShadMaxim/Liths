package com.example.serenitysoul.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.core.app.ActivityCompat
import androidx.core.app.ComponentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

object Utils {

    fun Context.isPermissionAskedForFirstTime(
        permission: String
    ): Boolean {

        return getSharedPreferences(
            packageName, MODE_PRIVATE
        ).getBoolean(permission, true)
    }

    fun Context.permissionAskedForFirsTime(
        permission: String
    ) {
        getSharedPreferences(
            packageName, MODE_PRIVATE
        ).edit().putBoolean(permission, false).apply()
    }

    fun Context.openApplicationSettings() {
        startActivity(Intent().apply {
            action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            data = Uri.parse("package:${packageName}")
        })
    }

    @Composable
    fun requestPermissions(
        activity: ComponentActivity,
        permission: String,
        onPermissionResult: (Boolean) -> Unit
    ) {
        val requestPermissionLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestMultiplePermissions()
        ) { permissionsMap ->
            val allGranted = permissionsMap.all { it.value }
            onPermissionResult(allGranted)
        }

        val isAllGranted =   activity.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED

        if (isAllGranted) {
            requestPermissionLauncher.launch(arrayOf(permission))
        } else {
            onPermissionResult(true)
        }
    }

    @OptIn(ExperimentalPermissionsApi::class)
    fun getTextToShowGivenPermissions(
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
    }
}

/*
object PermissionUtils {
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<Array<String>>

    private val _permissionLiveData = MutableLiveData<Boolean>()
    val permissionLiveData: LiveData<Boolean> = _permissionLiveData

    fun registerPermissionLauncher(activity: ComponentActivity) {
        requestPermissionLauncher =
            activity.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
                val allGranted = permissions.all { it.value }
                _permissionLiveData.value = allGranted
            }
    }

    fun requestPermissions(vararg permissions: String) {
        _permissionLiveData.value = false
        requestPermissionLauncher.launch(permissions)
    }
}
*/


