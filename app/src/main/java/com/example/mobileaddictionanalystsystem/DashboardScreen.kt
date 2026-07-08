package com.example.mobileaddictionanalystsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobileaddictionanalystsystem.charts.WeeklyChart
import com.example.mobileaddictionanalystsystem.components.StatCard
import com.example.mobileaddictionanalystsystem.tracker.AppUsage
import com.example.mobileaddictionanalystsystem.tracker.AppUsageTracker
import com.example.mobileaddictionanalystsystem.tracker.UsageTracker
import com.example.mobileaddictionanalystsystem.analyzer.UsageAnalyzer
import com.example.mobileaddictionanalystsystem.ai.RiskPredictor
import com.example.mobileaddictionanalystsystem.report.PdfReport
import com.example.mobileaddictionanalystsystem.notification.NotificationHelper
@Composable
fun DashboardScreen() {

    val context = LocalContext.current


    var screenTime by remember {
        mutableStateOf("Loading...")
    }

    var topApps by remember {
        mutableStateOf<List<AppUsage>>(emptyList())
    }
    var socialMediaTime by remember {
        mutableStateOf("0h 0m")
    }

    var gamingTime by remember {
        mutableStateOf("0h 0m")
    }

    LaunchedEffect(Unit) {

        val time = UsageTracker.getTodayScreenTime(context)
        screenTime = UsageTracker.formatTime(time)

        topApps = AppUsageTracker.getTopApps(context)

        socialMediaTime = UsageAnalyzer.formatTime(
            UsageAnalyzer.getSocialMediaTime(topApps)
        )

        gamingTime = UsageAnalyzer.formatTime(
            UsageAnalyzer.getGamingTime(topApps)
        )
    }

    val riskLevel = RiskPredictor.calculateRisk(
        screenTimeHours = 5.3f,
        socialHours = 2.5f,
        gamingHours = 1.2f
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FA))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

            Text(
                text = "📱 Mobile Addiction Analyst",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Today's Digital Wellness Summary",
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            StatCard(
                title = "📱 Screen Time",
                value = screenTime,
                color = Color(0xFF1976D2)
            )

            StatCard(
                title = "📲 Social Media",
                value = socialMediaTime,
                color = Color(0xFF43A047)
            )

            StatCard(
                title = "🎮 Gaming",
                value = gamingTime,
                color = Color(0xFFF57C00)
            )

            StatCard(
                title = "😴 Sleep",
                value = "7h 10m",
                color = Color(0xFF8E24AA)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE8F5E9)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "📊 Addiction Risk",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    LinearProgressIndicator(
                        progress = { 0.65f },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Risk Level : $riskLevel",
                        fontSize = 18.sp,
                        color = Color(0xFF2E7D32)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "💡 AI Recommendation",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "• Reduce social media by 30 minutes today.\n\n" +
                                "• Take a 10-minute break every hour.\n\n" +
                                "• Sleep at least 7–8 hours.\n\n" +
                                "• Limit gaming to under 1 hour.",
                        fontSize = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "📱 Top Apps Used Today",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    if (topApps.isEmpty()) {

                        Text("No app usage found.")

                    } else {

                        topApps.forEach { app ->

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {

                                Text(app.appName)

                                Text(
                                    AppUsageTracker.formatTime(app.usageTime),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            WeeklyChart()
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                PdfReport.generateReport(
                    context = context,
                    screenTime = screenTime,
                    socialMedia = socialMediaTime,
                    gaming = gamingTime,
                    sleep = "7h 10m",
                    risk = riskLevel
                )

            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("📄 Download PDF Report")
        }



            Spacer(modifier = Modifier.height(30.dp))
        }
    }
