package com.example.teachersapp.data.network.lesson

import com.google.gson.annotations.SerializedName

data class LessonRequest(
    @SerializedName("id")
    val Id: String,
    @SerializedName("studentName")
    val StudentName: String,
    @SerializedName("dateTime")
    val DateTime: String,
    @SerializedName("lessonType")
    val LessonType: String,
    @SerializedName("duration")
    val Duration: String

)
