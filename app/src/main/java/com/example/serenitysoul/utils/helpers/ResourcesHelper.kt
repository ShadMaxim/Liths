package com.example.serenitysoul.utils.helpers

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.serenitysoul.R
import java.io.File

class ResourcesHelper(private val context: Context) {

    fun getResources() = context.resources

    fun getString(stringId: Int): String = context.getString(stringId)

    fun getPluralString(stringId: Int, count: Int): String =
        context.resources.getQuantityString(stringId, count, count)

    fun getString(stringId: Int, vararg formatArgs: Any): String =
        context.getString(stringId, *formatArgs)

    fun getStringArray(stringId: Int): Array<String> = context.resources.getStringArray(stringId)

    fun getCacheDir(): File = context.cacheDir

    fun getColor(color: Int): Int = ContextCompat.getColor(context, color)

    fun copyToClipboard(value: String, toast: Boolean = true) {
        val clipboardService = context.getSystemService(Context.CLIPBOARD_SERVICE)
        val clipboardManager = clipboardService as ClipboardManager
        val clipData = ClipData.newPlainText("", value)
        clipboardManager.setPrimaryClip(clipData)
        if (toast)
            Toast.makeText(context, R.string.clipboard, Toast.LENGTH_SHORT).show()
    }
}
