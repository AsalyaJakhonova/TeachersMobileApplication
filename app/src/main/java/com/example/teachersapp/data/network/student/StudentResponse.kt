package com.example.teachersapp.data.network.student

import com.google.gson.annotations.SerializedName

open class StudentResponse(
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