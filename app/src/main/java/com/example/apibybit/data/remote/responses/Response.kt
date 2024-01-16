package com.example.apibybit.data.remote.responses

data class Response(
    val retCode: Int,
    val retMsg: String,
    val result: Result,
    val retExtInfo: RetExtInfo,
    val time: Long,
)
