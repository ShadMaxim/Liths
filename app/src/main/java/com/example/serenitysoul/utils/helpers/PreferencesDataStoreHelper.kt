package com.example.serenitysoul.utils.helpers

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.serenitysoul.utils.constants.Constants.PREFERENCES_NAME_DATA_STORE
import kotlinx.coroutines.flow.map

class PreferencesDataStoreHelper constructor(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME_DATA_STORE)
    }

    private val dataStore = context.dataStore

    suspend fun <T> putToDataStore(preferencesKey: Preferences.Key<T>, value: T) {
        dataStore.edit {preferences ->
            preferences[preferencesKey] = value
        }
    }

    fun <T> getFromDataStore(preferencesKey: Preferences.Key<T>, defaultValue: T) = dataStore.data.map {preferences ->
        preferences[preferencesKey]?: defaultValue
    }
}