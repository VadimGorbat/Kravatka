package com.example.kravatka.navigation

sealed class Routes(val route: String) {
    object Splash: Routes("splash")
    object Welcome: Routes("welcome")
    object SignIn: Routes("signIn")
    object SignUp: Routes("signUp")
    object Main: Routes("main")
}