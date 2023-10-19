package com.helloworldstudios.predictthenumber

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomePage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = stringResource(id = R.string.app_name), fontSize = 24.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_casino),
            contentDescription = stringResource(
                id = R.string.dice
            )
        )
        Button(onClick = {
            navController.navigate(Pages.predictPage.value)
        }) {
            Text(text = stringResource(id = R.string.start_game), fontSize = 24.sp)
        }
    }
}