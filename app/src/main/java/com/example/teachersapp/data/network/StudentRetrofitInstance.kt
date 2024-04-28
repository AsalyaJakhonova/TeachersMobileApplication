package com.example.teachersapp.data.network

import com.example.teachersapp.data.network.lesson.LessonService
import com.example.teachersapp.data.network.student.StudentService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
class StudentRetrofitInstance {
    companion object {
        val BASE_URL = "https://localhost:7271/"
        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
        }.build()
        fun getStudentRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
        val studentService: StudentService = getStudentRetrofitInstance()
            .create(StudentService::class.java)
    }
}