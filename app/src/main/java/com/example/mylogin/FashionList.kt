package com.example.mylogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

data class FashionItem(
    val imageRes: Int,
    val name: String,
    val price: String,
    val stock: Int
)

val fashionItems = listOf(
    FashionItem(R.drawable.items1, "Sweater", "Rp. 75,000", 4),
    FashionItem(R.drawable.items2, "Kemeja", "Rp. 55,000", 3),
    FashionItem(R.drawable.items1, "Sweater", "Rp. 75,000", 4),
    FashionItem(R.drawable.items2, "Kemeja", "Rp. 55,000", 3)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FashionListScreen(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Fashion", fontSize = 24.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(painter = painterResource(id = R.drawable.back), contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle filter action */ }) {
                        Icon(painter = painterResource(id = R.drawable.filter), contentDescription = "Filter")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(navController, selectedItem, onItemSelected = { selectedItem = it })
        },
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.padding(paddingValues)
        ) {
            items(fashionItems.size) { index ->
                val item = fashionItems[index]
                FashionItemCard(
                    imageRes = item.imageRes,
                    name = item.name,
                    price = item.price,
                    stock = item.stock
                )
            }
        }
    }
}

@Composable
fun FashionItemCard(
    imageRes: Int,
    name: String,
    price: String,
    stock: Int
) {
    var isFavorite by remember { mutableStateOf(false) }
    var itemCount by remember { mutableStateOf(1) }

    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = name,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = price, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Text(text = name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = "Stok: $stock", fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { isFavorite = !isFavorite }) {
                    Icon(
                        painter = painterResource(
                            id = if (isFavorite) R.drawable.favorite_filled else R.drawable.favorite_border
                        ),
                        contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites",
                        tint = if (isFavorite) Color.Red else Color.Gray
                    )
                }
                if (isFavorite) {
                    Text(text = "Tambah Stok", color = Color.Red, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                } else {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { if (itemCount > 1) itemCount-- }) {
                            Icon(
                                painter = painterResource(id = R.drawable.remove),
                                contentDescription = "Decrease",
                                tint = Color.Black
                            )
                        }
                        Text(text = "$itemCount", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        IconButton(onClick = { itemCount++ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.add),
                                contentDescription = "Increase",
                                tint = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FashionListScreenPreview() {
    FashionListScreen(navController = rememberNavController())
}