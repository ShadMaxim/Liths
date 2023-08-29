package com.example.serenitysoul.utils.helpers

import android.content.SharedPreferences
import java.math.BigDecimal
import javax.inject.Inject

class PreferencesHelper @Inject constructor(private val preferences: SharedPreferences) {

    fun putString(key: String, value: String): Boolean {
        return this.preferences.edit().putString(key, value).commit()
    }

    fun getString(key: String): String? {
        val str = this.preferences.getString(key, "")
        return if (str.isNullOrEmpty()) null else str
    }

    fun putStringSet(key: String, value: Set<String>): Boolean {
        return this.preferences.edit().putStringSet(key, value).commit()
    }

    fun getStringSet(key: String): Set<String> {
        val str = this.preferences.getStringSet(key, emptySet())
        return str.orEmpty()
    }

    fun putBool(key: String, value: Boolean): Boolean {
        return this.preferences.edit().putBoolean(key, value).commit()
    }

    fun getBool(key: String, defaultValue: Boolean = false): Boolean {
        return this.preferences.getBoolean(key, defaultValue)
    }

    fun putInt(key: String, value: Int): Boolean {
        return this.preferences.edit().putInt(key, value).commit()
    }

    fun getInt(key: String, defaultValue: Int = -1): Int {
        return this.preferences.getInt(key, defaultValue)
    }

    fun putLong(key: String, value: Long): Boolean {
        return this.preferences.edit().putLong(key, value).commit()
    }

    fun getLong(key: String, defaultValue: Long = -1L): Long {
        return this.preferences.getLong(key, defaultValue)
    }

//    fun putDecimal(key: String, value: BigDecimal): Boolean {
//        return this.preferences.edit().putString(key, value.toString()).commit()
//    }
//
//    fun getDecimal(key: String, defaultValue: BigDecimal = BigDecimal.ZERO): BigDecimal {
//        return this.preferences.getString(key, defaultValue.toString())?.decimalFromServer!!
//    }

    fun remove(key: String): Boolean {
        return this.preferences.edit().remove(key).commit()
    }

    fun isEmpty(key: String): Boolean {
        return !this.preferences.contains(key)
    }

//    inline fun <reified Obj> putObject(key: String, obj : Obj?) {
//        val json = Gson().toJson(obj, Obj::class.java)
//        putString(key, json)
//    }
//
//    inline fun <reified Obj> getObject(key: String) : Obj? {
//        val json = getString(key)
//        return Gson().fromJson(json, Obj::class.java)
//    }

    fun clearAll(): Boolean {
        return this.preferences.edit().clear().commit()
    }
}