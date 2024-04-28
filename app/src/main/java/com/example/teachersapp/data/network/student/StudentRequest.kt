package com.example.teachersapp.data.network.lesson

import com.google.gson.annotations.SerializedName

data class StudentRequest(
    @SerializedName("id")
    val Id: String,
    @SerializedName("name")
    val Name: String,
    @SerializedName("age")
    val Age: String,
    @SerializedName("phoneNumber")
    val PhoneNumber: String,
    @SerializedName("course")
    val Course: String

)
