package com.example.apibybit.announcementslist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.apibybit.data.models.AnnouncementsListEntry
import com.example.apibybit.ui.theme.RobotoCondensed

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
        AnnouncementsList(navController = navController)
    }
}

@Composable
fun AnnouncementsList(
    navController: NavController,
    viewModel: AnnouncementsListViewModel = hiltViewModel(),
) {
    val announcementsList by remember {
        viewModel.announcementsList
    }
    val loadError by remember {
        viewModel.loadError
    }

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemCount =
            if (announcementsList.size % 2 == 0) {
                announcementsList.size
            } else {
                announcementsList.size + 1
            }
        items(itemCount) {
            AnnouncementsRow(rowIndex = it, entries = announcementsList, navController = navController)
        }
    }
}

@Composable
fun AnnouncementsRow(
    rowIndex: Int,
    entries: List<AnnouncementsListEntry>,
    navController: NavController,
) {
    Row {
        AnnouncementsEntry(
            entry = entries[rowIndex],
            navController = navController,
            modifier = Modifier.weight(1f),
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun AnnouncementsEntry(
    entry: AnnouncementsListEntry,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: AnnouncementsListViewModel = hiltViewModel(),
) {
    Box(
        modifier =
            modifier
                .clip(RoundedCornerShape(10.dp)),
    ) {
        Column {
            Text(
                text = entry.title,
                fontFamily = RobotoCondensed,
                fontSize = 16.sp,
            )
            Text(
                text = entry.description,
                fontSize = 14.sp,
            )
            Text(
                text = entry.url,
                fontSize = 14.sp,
            )
        }
    }
}
