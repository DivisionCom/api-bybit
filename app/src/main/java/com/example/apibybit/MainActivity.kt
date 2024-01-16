package com.example.apibybit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apibybit.announcementslist.AnnouncementsListScreen
import com.example.apibybit.ui.theme.APIBybitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            APIBybitTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "announcements_list_screen",
                ) {
                    composable("announcements_list_screen") {
                        AnnouncementsListScreen(navController = navController)
                    }
                }
            }
        }
    }
}
