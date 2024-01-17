package com.example.apibybit.announcementslist

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
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

    Box(
        contentAlignment = Alignment.Center,
        modifier =
            Modifier
                .fillMaxSize(),
    ) {
        if (loadError.isNotEmpty()) {
            RetrySection(error = loadError) {
                viewModel.loadAnnouncements()
            }
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
    val uriHandler = LocalUriHandler.current
    Box(
        modifier =
            modifier
                .shadow(5.dp, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .border(2.dp, Color.Yellow, RoundedCornerShape(10.dp))
                .padding(8.dp)
                .aspectRatio(1.5f)
                .clickable {
                    uriHandler.openUri(entry.url)
                },
    ) {
        Column {
            Text(
                text = entry.title,
                fontFamily = RobotoCondensed,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = entry.description,
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Tags: ${entry.tags.size}",
            )
            TagsRow(entry = entry, navController = navController)
        }
    }
}

@Composable
fun TagsRow(
    entry: AnnouncementsListEntry,
    navController: NavController,
) {
    Column {
        Row {
            for (i in 0..<entry.tags.size) {
                Box(
                    modifier =
                        Modifier
                            .shadow(2.dp, RoundedCornerShape(5.dp))
                            .clip(RoundedCornerShape(5.dp))
                            .border(1.dp, Color.Gray, RoundedCornerShape(5.dp))
                            .padding(4.dp),
                ) {
                    Text(text = entry.tags[i])
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Composable
fun RetrySection(
    error: String,
    onRetry: () -> Unit,
) {
    Column {
        Text(
            text = error,
            color = Color.Red,
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { onRetry() },
            modifier =
                Modifier
                    .align(CenterHorizontally),
        ) {
            Text(text = "Retry")
        }
    }
}
