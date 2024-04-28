package com.example.teachersapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teachersapp.data.network.LessonRepository
import com.example.teachersapp.models.Lesson
import kotlinx.coroutines.launch

class StudentListViewModel(
    private val lessonRepository: LessonRepository
) : ViewModel() {
    val lessonsLiveData: MutableLiveData<List<Lesson>> by lazy {
        MutableLiveData<List<Lesson>>()
    }
    init {
        getAllStudents()
    }

    fun getAllStudents() {
        viewModelScope.launch {
            val lessons = lessonRepository.getLessonList()
            lessonsLiveData.value= lessons
        }
    }
}