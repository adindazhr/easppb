package com.example.mylogin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HistoryTopUpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        HistoryTopUpItem(
            icon = R.drawable.credit_card, // Replace with your icon resource
            title = "BNI Master Card",
            date = "Dec 12 2021 at 10:00 pm",
            amount = "Rp 500.000"
        )
        Spacer(modifier = Modifier.height(8.dp))
        HistoryTopUpItem(
            icon = R.drawable.gopay, // Replace with your icon resource
            title = "Gopay",
            date = "Dec 12 2021 at 10:00 pm",
            amount = "Rp 500.000"
        )
        Spacer(modifier = Modifier.height(8.dp))
        HistoryTopUpItem(
            icon = R.drawable.gopay, // Replace with your icon resource
            title = "Gopay",
            date = "Dec 12 2021 at 10:00 pm",
            amount = "Rp 1.000.000"
        )
    }
}

@Composable
fun HistoryTopUpItem(icon: Int, title: String, date: String, amount: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Icon",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Gray.copy(alpha = 0.1f), CircleShape)
                    .padding(8.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = date,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
            Text(
                text = amount,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD32F2F)
            )
        }
    }
}
