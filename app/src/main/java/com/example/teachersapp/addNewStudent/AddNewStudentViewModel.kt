package com.example.teachersapp.addNewStudent

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teachersapp.data.network.LessonRepository
import com.example.teachersapp.data.network.MyResponse
import com.example.teachersapp.data.network.MyStudentResponse
import com.example.teachersapp.data.network.StudentRepository
import com.example.teachersapp.models.Lesson
import com.example.teachersapp.models.Student
import kotlinx.coroutines.launch

class AddNewStudentViewModel(private val studentRepository: StudentRepository): ViewModel() {
    val insertResponseLiveData: MutableLiveData<MyStudentResponse> by  lazy {
        MutableLiveData<MyStudentResponse>()
    }

    fun SaveNewStudent(student: Student){
        viewModelScope.launch {
            try {
                val response = studentRepository.insertNewStudent(student)
                insertResponseLiveData.value = response

                Log.d("Update_Response", response.toString())
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}