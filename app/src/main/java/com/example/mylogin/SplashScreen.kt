package com.example.mylogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    // Navigate to the landing screen after a delay
    LaunchedEffect(Unit) {
        delay(SPLASH_SCREEN_DURATION)
        navController.navigate("landing") {
            popUpTo("splash") { inclusive = true }
        }
    }

    // Background color set to red
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD32F2F)), // Red color
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.alfamind), // Replace with your image resource
            contentDescription = "Alfamind Logo",
            modifier = Modifier.size(200.dp)
        )
    }
}

private const val SPLASH_SCREEN_DURATION = 2000L