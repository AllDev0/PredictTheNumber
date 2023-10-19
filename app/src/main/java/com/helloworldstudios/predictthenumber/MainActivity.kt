package com.helloworldstudios.predictthenumber

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.helloworldstudios.predictthenumber.ui.theme.PredictTheNumberTheme


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PredictTheNumberTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavHost(context = this@MainActivity)
                }
            }
        }
    }
}

@Composable
fun MainNavHost(context: Context) {
    val navController = rememberNavController()
    println(Pages.homePage.value)
    println(Pages.predictPage.value)
    println(Pages.resultPage.value)
    NavHost(navController = navController, startDestination = Pages.homePage.value) {
        composable(Pages.homePage.value) {
            HomePage(navController)
        }
        composable(Pages.predictPage.value) {
            PredictPage(navController, context)
        }

        composable("${Pages.resultPage.value}/{result}", arguments = listOf(
            navArgument("result") { type = NavType.BoolType }
        )) {
            val result = it.arguments?.getBoolean("result")
            ResultPage(navController, result, context)
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun HomepagePreview() {
//    PredictTheNumberTheme {
//        HomePage()
//    }
//}