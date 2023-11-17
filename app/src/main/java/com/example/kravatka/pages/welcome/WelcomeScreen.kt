package com.example.kravatka.pages.welcome

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kravatka.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun WelcomeScreen(
    viewModel: WelcomeViewModel,
    onNavigationToSignIn: () -> Unit,
    onNavigationToSignUp: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar()
        },
        content = {
            WelcomeScreenContent(
                modifier = Modifier.padding(it),
                onNavigationToSignIn = onNavigationToSignIn,
                onNavigationToSignUp = onNavigationToSignUp
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Welcome Screen",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(Purple40)
    )
}

@Composable
private fun WelcomeScreenContent(
    modifier: Modifier,
    onNavigationToSignIn: () -> Unit,
    onNavigationToSignUp: () -> Unit
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = "Navigation Sign In",
            modifier = Modifier.clickable {
                onNavigationToSignIn.invoke()
            }
        )
        Text(
            text = "Navigation Sign Up",
            modifier = Modifier.clickable {
                onNavigationToSignUp.invoke()
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun WelcomeScreenContentPreview(){
WelcomeScreen(
    viewModel = WelcomeViewModel(),
    onNavigationToSignIn = { /*TODO*/ },
    onNavigationToSignUp = { /*TODO*/ },
    )
}


