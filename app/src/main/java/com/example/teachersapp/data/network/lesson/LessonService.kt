package com.example.teachersapp.data.network.lesson
import com.example.teachersapp.data.network.MyItemResponse
import com.example.teachersapp.data.network.MyListResponse
import com.example.teachersapp.data.network.MyResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
interface LessonService {
    @GET("records/all")
    suspend fun getAllLessons(@Query("lesson_id") lesson_id: String):
            MyListResponse<LessonResponse>
    @POST("records")
    suspend fun insertNewLesson(
        @Query("lesson_id") lesson_id: String,
        @Body lessonRequest: LessonRequest

    ): MyResponse

    @GET("records/{record_id}")
    suspend fun getOneLessonById(
        @Path("record_id") record_id: String,
        @Query("lesson_id") lesson_id: String,

    ): MyItemResponse<LessonResponse>
}