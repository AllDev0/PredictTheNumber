package com.helloworldstudios.predictthenumber

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PredictPage(navController: NavController, context: Context) {
    var tfPredict = remember { mutableStateOf("") }
    val maxTries = 5
    var remainingTries = remember { mutableStateOf(maxTries) }
    var result: Boolean = false
    val hint = remember { mutableStateOf("") }
    val randomNumber = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = true) {
        randomNumber.value = Random.nextInt(101)
    }

    Log.e("Random Number", randomNumber.value.toString())

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = (stringResource(id = R.string.remaining_tries) + remainingTries.value),
            fontSize = 24.sp,
            color = Color.Red
        )
        Text(text = (stringResource(id = R.string.hint) + hint.value), fontSize = 24.sp)
        TextField(value = tfPredict.value, onValueChange = { tfPredict.value = it }, label = {
            Text(
                text = stringResource(id = R.string.predict)
            )
        })
        Button(onClick = {

            if (remainingTries.value == 0) {
                result = false
                navController.navigate("${Pages.resultPage.value}/$result") {
                    popUpTo(Pages.predictPage.value) {
                        inclusive = true
                    }
                }
            }

            val predict = tfPredict.value.toIntOrNull()

            if (predict != null) {
                remainingTries.value--
                if (predict > randomNumber.value) {
                    hint.value = context.getString(R.string.hint_decrease)
                } else if (predict < randomNumber.value) {
                    hint.value = context.getString(R.string.hint_increase)
                } else if (predict == randomNumber.value) {
                    result = true
                    navController.navigate("${Pages.resultPage.value}/$result") {
                        popUpTo(Pages.predictPage.value) {
                            inclusive = true
                        }
                    }

                    return@Button
                }
            }
            tfPredict.value = ""
        }) {
            Text(text = stringResource(id = R.string.guess_the_number), fontSize = 24.sp)
        }
    }
}