package com.example.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mylogin.ui.theme.MyLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "splash") {
                composable("splash") { SplashScreen(navController) }
                composable("landing") { LandingScreen(navController) }
                composable("login") { LoginScreen(navController) }
                composable("home") { HomeScreen(navController) }
                composable("flight") { FlightListScreen() }
                composable("signup") { SignupScreen(navController) }
                composable("fashionlist") { FashionListScreen(navController) }
                composable("topup") { TopUpScreen(navController) }
                composable("profile") { ProfileScreen(navController) }
            }
        }
    }
}
