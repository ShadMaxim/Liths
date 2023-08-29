package com.example.serenitysoul.viewmodels.vm

import androidx.lifecycle.viewModelScope
import com.example.serenitysoul.data.Session
import com.example.serenitysoul.navigation.Screen
import com.example.serenitysoul.usecases.uc.SplashUseCase
import com.example.serenitysoul.viewmodels.baseviewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel<Unit, SplashUseCase>() {

    override fun sendNavigationEvent() {
        navigationEvent.value = Screen.SplashScreen.route
        viewModelScope.launch {
            useCase().collectLatest {

            }
        }
    }
}