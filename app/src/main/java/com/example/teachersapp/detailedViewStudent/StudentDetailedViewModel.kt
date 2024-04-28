package com.example.teachersapp.detailedViewStudent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teachersapp.data.network.LessonRepository
import com.example.teachersapp.models.Lesson
import androidx.lifecycle.viewModelScope
import com.example.teachersapp.data.network.StudentRepository
import com.example.teachersapp.models.Student
import kotlinx.coroutines.launch

class StudentDetailedViewModel(
    studentId: String,
    private val studentRepository: StudentRepository
) : ViewModel(){
    val studentLiveData: MutableLiveData<Student> by lazy {
        MutableLiveData<Student>()
    }
    init {
        getStudentByIdFromRemoteDatabase(studentId)
    }
    private fun getStudentByIdFromRemoteDatabase(studentId: String){
        viewModelScope.launch{
            if(!studentId.isNullOrEmpty()) {
                val student = studentRepository.getStudentById(studentId)
                studentLiveData.value = student
            }
        }
    }
}
