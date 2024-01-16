package com.example.apibybit.repository

import com.example.apibybit.data.remote.BybitApi
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class BybitRepository
    @Inject
    constructor(
        private val api: BybitApi,
    )
