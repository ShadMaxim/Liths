package com.example.serenitysoul.di.modules

import android.content.Context
import com.example.serenitysoul.utils.constants.Constants.PREFERENCES_NAME
import com.example.serenitysoul.utils.helpers.PreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PreferencesHelperModule @Inject constructor() {

    @Provides
    @Singleton
    fun providePreferences(@ApplicationContext ctx: Context): PreferencesHelper {
        return PreferencesHelper(
            ctx.getSharedPreferences(
                PREFERENCES_NAME,
                Context.MODE_PRIVATE
            )
        )
    }
}