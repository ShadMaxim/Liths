package com.example.serenitysoul.viewmodels.baseviewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.serenitysoul.navigation.Screen
import com.example.serenitysoul.usecases.BaseUseCase
import javax.inject.Inject

abstract class  BaseViewModel<StateView, UseCase : BaseUseCase<*,*>> : ViewModel() {

    @Inject
    lateinit var useCase: UseCase

    //protected val uiState: MutableState<String> = mutableStateOf("Default")

    protected val navigationEvent: MutableState<String> = mutableStateOf(Screen.SplashScreen.route)

    fun getEvent(): State<String> = navigationEvent

    abstract fun sendNavigationEvent()
}