package com.example.serenitysoul.navigation

import androidx.navigation.NavController

fun navUtils(
    navController: NavController,
    route: String
) {
    navController.navigate(route = route)
}