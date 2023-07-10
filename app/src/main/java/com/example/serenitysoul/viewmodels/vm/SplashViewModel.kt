package com.example.serenitysoul.viewmodels.vm

import com.example.serenitysoul.navigation.Screen
import com.example.serenitysoul.viewmodels.baseviewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel<Unit>() {

    /*init {
        navigationEvent.value = Screen.SplashScreen.route
    }*/

    override fun sendNavigationEvent() {
        navigationEvent.value = Screen.SplashScreen.route
    }
}