package com.example.serenitysoul.di.modules

import android.content.Context
import com.example.serenitysoul.utils.helpers.ResourcesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ResourcesHelperModule {

    @Provides
    @Singleton
    fun provideResourcesHelper(@ApplicationContext context: Context): ResourcesHelper {
        return ResourcesHelper(context)
    }
}