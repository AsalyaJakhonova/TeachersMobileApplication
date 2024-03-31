package com.example.teachersapp.addnew

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teachersapp.data.network.LessonRepository
import com.example.teachersapp.data.network.MyResponse
import com.example.teachersapp.models.Lesson
import kotlinx.coroutines.launch

class AddNewLessonViewModel(private val lessonRepository: LessonRepository): ViewModel() {
    val insertResponseLiveData: MutableLiveData<MyResponse> by  lazy {
        MutableLiveData<MyResponse>()
    }

    fun SaveNewLesson(lesson: Lesson){
        viewModelScope.launch {
            try {
                val response = lessonRepository.insertNewLesson(lesson)
                insertResponseLiveData.value = response

                Log.d("Update_Response", response.toString())
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}