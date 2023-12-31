package com.example.kravatka.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kravatka.navigation.Routes
import com.example.kravatka.pages.splash_screen.SplashScreen
import com.example.kravatka.pages.splash_screen.SplashViewModel
import com.example.kravatka.pages.welcome.WelcomeScreen
import com.example.kravatka.pages.welcome.WelcomeViewModel
import com.example.kravatka.ui.theme.KravatkaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KravatkaTheme {
                RootAppNavigation()
            }
        }
    }
}

@Composable
fun RootAppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Routes.Splash.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.Splash.route) {
            val viewModel = hiltViewModel<SplashViewModel>()
            SplashScreen(
                viewModel = viewModel,
                onNavigationNext = {
                    navController.navigate(route = Routes.Welcome.route) {
                        popUpTo(0)
                    }
                }
            )
        }
        composable(Routes.Welcome.route) {
            val viewModel = hiltViewModel<WelcomeViewModel>()
            WelcomeScreen(
                viewModel = viewModel,
                onNavigationToSignIn = {
                    navController.navigate(route = Routes.SignIn.route)
                },
                onNavigationToSignUp = {
                    navController.navigate(route = Routes.SignUp.route)
                },
            )
        }
        composable(Routes.Main.route) {

        }
        composable(Routes.SignUp.route) {

        }
        composable(Routes.SignIn.route) {

        }
    }
}


