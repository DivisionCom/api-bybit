package com.example.apibybit.data.remote.responses

data class Announcement(
    val title: String,
    val description: String,
    val type: TypeX,
    val tags: List<String>,
    val url: String,
    val dateTimestamp: Long,
    val startDateTimestamp: Long,
    val endDateTimestamp: Long,
)
