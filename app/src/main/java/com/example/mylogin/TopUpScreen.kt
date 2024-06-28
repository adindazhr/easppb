package com.example.mylogin

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopUpScreen(navController: NavController) {
    var selectedItem by remember { mutableStateOf(1) }
    var selectedTabIndex by remember { mutableStateOf(0) }
    var selectedAmount by remember { mutableStateOf(500000) }
    val amounts = listOf(20000, 50000, 100000, 200000, 500000, 1000000)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Top Up", fontSize = 24.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(navController, selectedItem, onItemSelected = { selectedItem = it })
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(Color(0xFFF5F5F5)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                TopUpTabs(selectedTabIndex = selectedTabIndex, onTabSelected = { selectedTabIndex = it })
                Spacer(modifier = Modifier.height(16.dp))
                if (selectedTabIndex == 0) {
                    Text(
                        text = "Pilih jumlah topup",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TopUpOptions(amounts = amounts, selectedAmount = selectedAmount, onAmountSelected = { selectedAmount = it })
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = { /* Handle top-up action */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp)
                            .height(48.dp)
                    ) {
                        Text(text = "Top Up", color = Color.White, fontSize = 18.sp)
                    }
                } else {
                    HistoryTopUpScreen()
                }
            }
        }
    )
}

@Composable
fun TopUpTabs(selectedTabIndex: Int, onTabSelected: (Int) -> Unit) {
    val tabs = listOf("Top Up", "History Top Up")

    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.Transparent,
        contentColor = Color(0xFFD32F2F)
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) },
                text = {
                    Text(
                        text = title,
                        color = if (selectedTabIndex == index) Color(0xFFD32F2F) else Color.Gray,
                        fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal
                    )
                }
            )
        }
    }
}

@Composable
fun TopUpOptions(amounts: List<Int>, selectedAmount: Int, onAmountSelected: (Int) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (i in amounts.indices step 3) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (j in 0..2) {
                    if (i + j < amounts.size) {
                        TopUpOption(
                            amount = amounts[i + j],
                            isSelected = selectedAmount == amounts[i + j],
                            onClick = { onAmountSelected(amounts[i + j]) }
                        )
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun TopUpOption(amount: Int, isSelected: Boolean, onClick: () -> Unit) {
    val borderColor = if (isSelected) Color(0xFFD32F2F) else Color.Transparent

    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .size(100.dp)
            .clickable { onClick() }
            .border(2.dp, borderColor, RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.money), // Replace with your money icon resource
                contentDescription = "Money Icon",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Rp ${amount / 1000},000",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TopUpScreenPreview() {
    TopUpScreen(navController = rememberNavController())
}
