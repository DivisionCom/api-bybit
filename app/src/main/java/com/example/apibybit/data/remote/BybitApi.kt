package com.example.apibybit.data.remote

import com.example.apibybit.data.remote.responses.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BybitApi {
    @GET("announcements/index")
    suspend fun getAnnouncementsList(
        @Query("locale") locale: String,
        @Query("limit") limit: Int,
    ): Response
}
