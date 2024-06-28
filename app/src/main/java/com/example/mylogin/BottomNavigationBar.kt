package com.example.mylogin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(
    navController: NavController,
    selectedItem: Int,
    onItemSelected: (Int) -> Unit
) {
    val items = listOf("Produk", "Top Up", "Profil")
    val redColor = Color(0xFFC31508)

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.White
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = selectedItem == index
            val backgroundColor = if (isSelected) redColor else Color.Transparent
            val contentColor = if (isSelected) Color.White else Color.Gray

            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(backgroundColor)
                    .clickable {
                        onItemSelected(index)
                        when (index) {
                            0 -> navController.navigate("home") { launchSingleTop = true }
                            1 -> navController.navigate("topup") { launchSingleTop = true }
                            2 -> navController.navigate("profile") { launchSingleTop = true }
                        }
                    }
                    .padding(vertical = 18.dp, horizontal = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    when (item) {
                        "Produk" -> Icon(
                            painter = painterResource(id = R.drawable.produk),
                            contentDescription = item,
                            tint = contentColor
                        )
                        "Top Up" -> Icon(
                            painter = painterResource(id = R.drawable.topup),
                            contentDescription = item,
                            tint = contentColor
                        )
                        "Profil" -> Icon(
                            painter = painterResource(id = R.drawable.profil),
                            contentDescription = item,
                            tint = contentColor
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = item,
                        color = contentColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
