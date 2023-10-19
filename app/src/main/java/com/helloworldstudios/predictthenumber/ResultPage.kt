package com.helloworldstudios.predictthenumber

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ResultPage(navController: NavController, result: Boolean?, context: Context) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        if (result == null) {
            Toast.makeText(
                context,
                stringResource(id = R.string.something_went_wrong),
                Toast.LENGTH_LONG
            ).show()
        } else {
            if (result) {
                Text(text = stringResource(id = R.string.you_win), fontSize = 24.sp)
                Image(
                    painter = painterResource(id = R.drawable.ic_happy),
                    contentDescription = stringResource(
                        id = R.string.happy_image
                    )
                )
            } else {
                Text(text = stringResource(id = R.string.you_lost), fontSize = 24.sp)
                Image(
                    painter = painterResource(id = R.drawable.ic_sad),
                    contentDescription = stringResource(
                        id = R.string.sad_image
                    )
                )
            }
        }
    }
}