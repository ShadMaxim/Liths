package com.example.serenitysoul.feature.datasource

import androidx.datastore.core.DataStore
import com.example.serenitysoul.utils.helpers.PreferencesDataStoreHelper
import com.example.serenitysoul.utils.helpers.PreferencesHelper
import com.example.serenitysoul.utils.helpers.ResourcesHelper
import javax.inject.Inject

abstract class BaseDataSource {

    @Inject
    lateinit var preference: PreferencesHelper

    @Inject
    lateinit var resources: ResourcesHelper

    @Inject
    lateinit var dataStore: PreferencesDataStoreHelper
}