package com.example.teachersapp.data.network

import android.util.Log
import com.example.teachersapp.data.network.lesson.LessonRequest
import com.example.teachersapp.data.network.lesson.LessonResponse
import com.example.teachersapp.data.network.lesson.StudentRequest
import com.example.teachersapp.data.network.student.StudentResponse
import com.example.teachersapp.models.Lesson
import com.example.teachersapp.models.Student


class StudentRepository{
    suspend fun getSudentList(): List<Student>{
        val students = mutableListOf<Student>()
        try {


            val response: MyStudentListResponse<StudentResponse> =
                StudentRetrofitInstance.studentService.getAllStudents("student")
            val studentsFromResponse = response.data
            if (studentsFromResponse != null) {
                for (studentsFromResponse in studentsFromResponse) {
                    if (studentsFromResponse.Name!= null) {
                        students.add(
                            Student(
                                studentsFromResponse.Id,
                                studentsFromResponse.Name.uppercase(),
                                studentsFromResponse.Age,
                                studentsFromResponse.PhoneNumber,
                                studentsFromResponse.Course



                            )
                        )
                    }
                }
            }
        } catch (ex: Exception){
            ex.printStackTrace()

        }
        return students
    }
    suspend fun insertNewStudent(student: Student): MyStudentResponse?{
        var response: MyStudentResponse
        try {
            val studentRequest=
                StudentRequest(student.Id, student.Name, student.Age,student.PhoneNumber, student.Course)
            response = StudentRetrofitInstance.studentService.insertNewStudent("student", studentRequest)
            Log.d("Update_response", response.toString())
        }catch (e: Exception){
            e.printStackTrace()
            return null
        }
        return response
    }

    suspend fun getStudentById(studentId: String): Student? {

        try {


            val response: MyStudentItemResponse<StudentResponse> =
                StudentRetrofitInstance.studentService.getOneStudentById(studentId, "student")
            val studentFromResponse = response.data
            if (studentFromResponse != null) {
                if (studentFromResponse.Name != null){
                    return Student(
                        Id = studentId,
                        Name = studentFromResponse.Name,
                        Age = studentFromResponse.Age,
                        PhoneNumber = studentFromResponse.PhoneNumber,
                        Course = studentFromResponse.Course
                    )
                }

            }
        } catch (ex: Exception){
            ex.printStackTrace()

        }
        return null
    }
}


