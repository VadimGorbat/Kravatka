package com.example.kravatka.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kravatka.ui.theme.PrimaryButtonColor

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    text: String,
    onClick: () -> Unit,

    ) {
    Box(modifier = modifier) {
        Button(
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(PrimaryButtonColor),
            onClick = onClick,
            enabled = isEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .height(49.dp)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    text: String,
    onClick: () -> Unit,
) {
    Box(modifier = modifier) {
        OutlinedButton(
            border = BorderStroke(2.dp, color = PrimaryButtonColor),
            shape = RoundedCornerShape(8.dp),
            onClick = onClick,
            enabled = isEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .height(49.dp)
        )
        {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}


@Composable
fun CircleButton(
    modifier: Modifier = Modifier,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    icon: @Composable () -> Unit,
    onClick: () -> Unit
) {
    Box(modifier = modifier) {
        FloatingActionButton(
            onClick = onClick,
            containerColor = PrimaryButtonColor,
            elevation = elevation,
        ) {
            icon.invoke()
        }
    }
}

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean,
    onClick: () -> Unit
){
    Box(modifier = modifier){
        Button(
            shape = RoundedCornerShape(16.dp),
            enabled = isEnabled,
            contentPadding = PaddingValues(start = 5.dp, end = 5.dp),
            onClick = onClick,
            modifier = modifier
                .height(28.dp),
            colors = ButtonDefaults.buttonColors(PrimaryButtonColor)
        ) {
            Text(
                text = text,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun SquareButton(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    isEnabled: Boolean,
    elevation: ButtonElevation = ButtonDefaults.buttonElevation(),
    onClick: () -> Unit
) {
    Box(modifier = modifier) {
        Button(
            shape = RoundedCornerShape(16.dp),
            enabled = isEnabled,
            elevation = elevation,
            contentPadding = PaddingValues(4.dp),
            onClick = onClick,
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(PrimaryButtonColor)
        )
        {
            icon.invoke()
        }
    }
}

@Preview(showBackground = true)
@Composable()
fun ButtonsPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        PrimaryButton(
            modifier = Modifier,
            isEnabled = true,
            text = "Primary Button",
            onClick = {}
        )
        PrimaryButton(
            modifier = Modifier,
            isEnabled = false,
            text = "Primary Button",
            onClick = {}
        )
        SecondaryButton(
            modifier = Modifier,
            isEnabled = true,
            text = "Secondary Button",
            onClick = {}
        )
        SecondaryButton(
            modifier = Modifier,
            isEnabled = false,
            text = "Secondary Button",
            onClick = {}
        )
        CircleButton(icon = {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "add_button"
            )
        },
            modifier = Modifier,
            onClick = {}
        )
        SquareButton(icon = {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "notification"
            )
        },
            isEnabled = true,
            modifier = Modifier,
            onClick = {}
        )
        SmallButton(
            text = "Small Button enabled",
            isEnabled = true,
            onClick = {}
        )
        SmallButton(
            text = "Small Button disabled",
            isEnabled = false,
            onClick = {}
        )
    }
}