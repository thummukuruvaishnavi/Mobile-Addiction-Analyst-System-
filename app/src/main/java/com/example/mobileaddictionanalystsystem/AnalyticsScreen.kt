package com.example.mobileaddictionanalystsystem

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobileaddictionanalystsystem.analytics.AnalyticsManager

@Composable
fun AnalyticsScreen() {

    val analytics = AnalyticsManager.getAnalyticsData()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "📊 Analytics",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        AnalyticsCard("Daily Average", analytics.dailyAverage)
        AnalyticsCard("Weekly Average", analytics.weeklyAverage)
        AnalyticsCard("Social Media", analytics.socialMedia)
        AnalyticsCard("Gaming", analytics.gaming)

        Spacer(modifier = Modifier.height(20.dp))

        Card {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    "Productivity Score",
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                LinearProgressIndicator(
                    progress = { analytics.productivity / 100f },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text("${analytics.productivity}%")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    "Addiction Risk",
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                LinearProgressIndicator(
                    progress = { analytics.addictionRisk / 100f },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text("${analytics.addictionRisk}%")
            }
        }
    }
}