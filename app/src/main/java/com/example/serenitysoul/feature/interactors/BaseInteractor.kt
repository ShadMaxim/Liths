package com.example.serenitysoul.feature.interactors

abstract class BaseInteractor {

    open fun doOnLogout() = doOnExit()

    abstract fun doOnExit()
}