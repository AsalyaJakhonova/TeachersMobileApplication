package com.example.teachersapp.data.network.student

import com.example.teachersapp.data.network.MyItemResponse
import com.example.teachersapp.data.network.MyListResponse
import com.example.teachersapp.data.network.MyResponse
import com.example.teachersapp.data.network.MyStudentItemResponse
import com.example.teachersapp.data.network.MyStudentListResponse
import com.example.teachersapp.data.network.MyStudentResponse
import com.example.teachersapp.data.network.lesson.LessonRequest
import com.example.teachersapp.data.network.lesson.LessonResponse
import com.example.teachersapp.data.network.lesson.StudentRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface StudentService {
    @GET("records/all")
    suspend fun getAllStudents(@Query("student_id") student_id: String):
            MyStudentListResponse<StudentResponse>
    @POST("records")
    suspend fun insertNewStudent(
        @Query("student_id") student_id: String,
        @Body studentRequest: StudentRequest

    ): MyStudentResponse

    @GET("records/{record_id}")
    suspend fun getOneStudentById(
        @Path("record_id") record_id: String,
        @Query("student_id") student_id: String,

        ): MyStudentItemResponse<StudentResponse>
}