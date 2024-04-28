package com.example.teachersapp.data.network

import com.google.gson.annotations.SerializedName

data class MyStudentItemResponse<T>(
    @SerializedName("code")
    val code: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: T?
)
