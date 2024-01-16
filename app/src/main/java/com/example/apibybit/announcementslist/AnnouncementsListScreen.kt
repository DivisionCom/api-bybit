package com.example.apibybit.announcementslist

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun AnnouncementsListScreen(
    navController: NavController,
    viewModel: AnnouncementsListViewModel = hiltViewModel(),
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun AnnouncementsList(
    navController: NavController,
    viewModel: AnnouncementsListViewModel = hiltViewModel(),
) {

}
