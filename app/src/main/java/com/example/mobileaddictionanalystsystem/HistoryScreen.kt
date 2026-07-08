package com.example.mobileaddictionanalystsystem

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class HistoryItem(
    val date: String,
    val screenTime: String,
    val risk: String
)

@Composable
fun HistoryScreen() {

    val history = listOf(
        HistoryItem("01 Jul", "5h 10m", "🟡 Moderate"),
        HistoryItem("02 Jul", "4h 30m", "🟢 Low"),
        HistoryItem("03 Jul", "6h 45m", "🔴 High"),
        HistoryItem("04 Jul", "5h 20m", "🟡 Moderate")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "📅 Usage History",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(history) { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = item.date,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text("📱 Screen Time: ${item.screenTime}")
                        Text("⚠ Risk: ${item.risk}")
                    }
                }
            }
        }
    }
}