package com.example.apibybit.repository

import com.example.apibybit.data.remote.BybitApi
import com.example.apibybit.data.remote.responses.Response
import com.example.apibybit.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class BybitRepository
    @Inject
    constructor(
        private val api: BybitApi,
    ) {
        suspend fun getAnnouncementsList(
            locale: String,
            limit: Int,
        ): Resource<Response> {
            val response =
                try {
                    api.getAnnouncementsList(locale, limit)
                } catch (e: Exception) {
                    return Resource.Error("An unknown error occured.")
                }
            return Resource.Success(response)
        }
    }
