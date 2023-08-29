package com.example.serenitysoul.utils.permission

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

object PermissionCoroutine {

    /*suspend fun request(activity: AppCompatActivity?, permission: String) =
        suspendCoroutine<PermissionResult> { continuation ->

            val listener = object : IPermissionResult {
                override fun handlePermissionResult(statusMap: HashMap<String, PermissionResult>) {
                    if (statusMap.containsKey(permission)) {
                        continuation.resume(statusMap[permission]!!)
                    } else {
                        continuation.resume(PermissionResult(PermissionStatus.DONT_ASK_AGAIN))
                    }
                }
            }

            if (activity == null || activity.isFinishing) {
                continuation.resume(PermissionResult(PermissionStatus.ONE_TIME_DENIAL))
                return@suspendCoroutine
            }
            if (ContextCompat.checkSelfPermission(activity, permission) == PERMISSION_GRANTED) {
                continuation.resume(PermissionResult(PermissionStatus.GRANTED))
                return@suspendCoroutine
            }
            startPermissionFragment(activity, listOf(permission), listener)
        }*/


    suspend fun request(activity: Activity, permissions: List<String>, onError: () -> Unit, onSuccess: () -> Unit ) =
        suspendCoroutine<Map<String, Boolean>> { continuation ->

            /*val listener = object : IPermissionResult {
                override fun handlePermissionResult(statusMap: HashMap<String, PermissionResult>) {
                    continuation.resume(statusMap)
                }
            }*/
            //activity?.onRequestPermissionsResult()

            val statusMap = HashMap<String, Boolean>()

            for (i in permissions.indices) {
                val name = permissions[i]
                when {
                    /*grantResults[i] == PackageManager.PERMISSION_GRANTED ->
                        statusMap[name] = true*/

                    shouldShowRequestPermissionRationale(activity, name) ->
                        statusMap[name] = true

                    else ->
                        statusMap[name] = false
                }
            }

            if (activity == null || activity.isFinishing) {
                continuation.resume(emptyMap())
                return@suspendCoroutine
            }
            //startPermissionFragment(activity, permissions, listener)
        }

    /*fun showPermissionSettings(activity: AppCompatActivity?) {
        if (activity == null) {
            return
        }
        activity.startActivity(
            Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", activity.packageName, null),
            )
        )
    }*/

    /*private fun startPermissionFragment(
        activity: AppCompatActivity,
        permissions: List<String>,
        listener: IPermissionResult
    ) {
        val tag = "brahman_perm_frag"

        val fragManager = activity.supportFragmentManager
        val permissionFrag =
            fragManager.findFragmentByTag(tag) as? PermissionFragment

        if (permissionFrag != null) {
            permissionFrag.listener = listener
            return
        }

        activity.runOnUiThread {
            val newFrag = PermissionFragment.getInstance(permissions, listener)
            fragManager
                .beginTransaction()
                .add(newFrag, tag)
                .commitAllowingStateLoss()
        }
    }*/

}