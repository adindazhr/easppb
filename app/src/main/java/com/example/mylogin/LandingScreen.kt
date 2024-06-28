package com.example.mylogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LandingScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD32F2F)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top logo
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = R.drawable.alfamind), // Replace with your image resource
            contentDescription = "Alfamind Logo",
            modifier = Modifier.size(200.dp)
        )

        // Welcome Card
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color(0xFFD32F2F)), // Ensure the background stays red
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF5F5F5),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // This makes the card fill the remaining space
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Selamat Datang di Alfamind",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Alfamind adalah platform digital inovatif yang memungkinkan pengguna untuk memiliki toko Alfamart virtual tanpa perlu kehadiran fisik.\n",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    // Daftar Button
                    Button(
                        onClick = { navController.navigate("signup") }, // Navigate to Sign Up
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Text(text = "Daftar", color = Color.White, fontSize = 24.sp)
                    }

                    Text(
                        text = "atau",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    // Google Button
                    OutlinedButton(
                        onClick = { /* Handle Google click */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp) // Added padding here
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.google), // Replace with your Google icon resource
                            contentDescription = "Google Icon",
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Lanjutkan dengan Google", color = Color.Black, fontSize = 18.sp)
                    }

                    // Login Text
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Sudah Punya Akun ? ",
                            fontSize = 18.sp,
                            color = Color.Gray
                        )
                        Text(
                            text = "Login",
                            fontSize = 18.sp,
                            color = Color(0xFFD32F2F),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable { navController.navigate("login") }
                        )
                    }
                }
            }
        }
    }
}