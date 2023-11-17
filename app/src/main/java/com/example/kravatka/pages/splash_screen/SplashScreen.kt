package com.example.kravatka.pages.splash_screen

import android.window.SplashScreenView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.example.kravatka.ui.theme.Purple40

@Composable
fun SplashScreen(
    viewModel: SplashViewModel,
    onNavigationNext: () -> Unit
) {
    Scaffold(
        topBar = { TopBar() },
        content = {
            SplashScreenContent(
                modifier = Modifier.padding(it),
                onNavigationNext = onNavigationNext
            )
        }
    ) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Splash",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(Purple40)
    )
}

@Composable
private fun SplashScreenContent(
    modifier: Modifier,
    onNavigationNext: () -> Unit
) {
    Column(modifier = modifier) {
        Text(text = "splashScreen",
            modifier = modifier.clickable {
                onNavigationNext.invoke()
            })
    }
}