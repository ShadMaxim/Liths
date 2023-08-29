package com.example.serenitysoul.di.modules

import android.content.Context
import com.example.serenitysoul.utils.helpers.PreferencesDataStoreHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PreferencesDataStoreModule @Inject constructor() {

    @Provides
    @Singleton
    fun providePreferencesDataStore(@ApplicationContext context: Context): PreferencesDataStoreHelper {
        return PreferencesDataStoreHelper(context)
    }
}