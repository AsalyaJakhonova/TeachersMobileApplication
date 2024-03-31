package com.example.teachersapp.detailedView

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teachersapp.data.network.LessonRepository
import com.example.teachersapp.models.Lesson
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DetailedViewModel(
    lessonId: String,
    private val lessonRepository: LessonRepository
) : ViewModel(){
    val lessonLiveData: MutableLiveData<Lesson> by lazy {
        MutableLiveData<Lesson>()
    }
    init {
        getLessonByIdFromRemoteDatabase(lessonId)
    }
    private fun getLessonByIdFromRemoteDatabase(lessonId: String){
        viewModelScope.launch{
            if(!lessonId.isNullOrEmpty()) {
                val lesson = lessonRepository.getLessonById(lessonId)
                lessonLiveData.value = lesson
            }
        }
    }
}
