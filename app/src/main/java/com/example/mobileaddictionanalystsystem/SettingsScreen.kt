package com.example.mobileaddictionanalystsystem

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobileaddictionanalystsystem.theme.ThemeViewModel

@Composable
fun SettingsScreen(
    themeViewModel: ThemeViewModel
) {

    var notificationsEnabled by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "⚙ Settings",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                // Notifications
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text("Enable Notifications")

                    Switch(
                        checked = notificationsEnabled,
                        onCheckedChange = {
                            notificationsEnabled = it
                        }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Dark Mode
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text("Dark Mode")

                    Switch(
                        checked = themeViewModel.isDarkTheme,
                        onCheckedChange = {
                            themeViewModel.toggleTheme()
                        }
                    )
                }
            }
        }
    }
}