package com.example.mobileaddictionanalystsystem.charts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeeklyChart() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "📊 Weekly Screen Time",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            DayProgress("Monday", 4f / 8f)
            DayProgress("Tuesday", 6f / 8f)
            DayProgress("Wednesday", 3f / 8f)
            DayProgress("Thursday", 7f / 8f)
            DayProgress("Friday", 5f / 8f)
            DayProgress("Saturday", 8f / 8f)
            DayProgress("Sunday", 4f / 8f)
        }
    }
}

@Composable
fun DayProgress(day: String, progress: Float) {

    Column(
        modifier = Modifier.padding(vertical = 6.dp)
    ) {

        Text(day)

        Spacer(modifier = Modifier.height(4.dp))

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth()
        )
    }
}