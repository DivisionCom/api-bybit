package com.example.apibybit.announcementslist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apibybit.data.models.AnnouncementsListEntry
import com.example.apibybit.repository.BybitRepository
import com.example.apibybit.util.Constants.API_LIMIT
import com.example.apibybit.util.Constants.API_LOCALE
import com.example.apibybit.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnnouncementsListViewModel
    @Inject
    constructor(
        private val repository: BybitRepository,
    ) : ViewModel() {
        var announcementsList = mutableStateOf<List<AnnouncementsListEntry>>(listOf())
        var loadError = mutableStateOf("")

        init {
            loadAnnouncements()
        }

        fun loadAnnouncements() {
            viewModelScope.launch {
                val result = repository.getAnnouncementsList(API_LOCALE, API_LIMIT)
                when (result) {
                    is Resource.Success -> {
                        val announcementsEntries =
                            result.data?.result?.list?.mapIndexed { index, entry ->
                                AnnouncementsListEntry(
                                    entry.title,
                                    entry.description,
                                    entry.url,
                                )
                            }
                        announcementsList.value = announcementsEntries!!
                    }
                    is Resource.Error -> {
                        loadError.value = result.message!!
                    }
                }
            }
        }
    }
