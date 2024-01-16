package com.example.apibybit.announcementslist

import androidx.lifecycle.ViewModel
import com.example.apibybit.repository.BybitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnnouncementsListViewModel
@Inject
constructor(
    private val repository: BybitRepository,
) : ViewModel() {

}
