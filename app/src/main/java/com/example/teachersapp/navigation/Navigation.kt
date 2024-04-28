package com.example.teachersapp.navigation

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.teachersapp.LessonsList
import com.example.teachersapp.StudentList
import com.example.teachersapp.addNewStudent.AddNewStudent
import com.example.teachersapp.addnew.AddNewLesson
import com.example.teachersapp.detailedView.DetailedView
import com.example.teachersapp.detailedViewStudent.StudentDetailedView
import com.example.teachersapp.editStudent.EditStudent
import com.example.teachersapp.edtiLesson.EditLesson
import com.example.teachersapp.models.Lesson
import com.example.teachersapp.models.Student
import java.util.jar.Attributes.Name

@Composable
fun Navigation(navController: NavHostController) {
    val lessons = mutableListOf(
        Lesson(Id = "1", DateTime = "2022-02-22", LessonType= "PartTime", StudentName="Student", Duration="12"),
        Lesson(Id = "2", DateTime = "2022-02-22", LessonType= "PartTime", StudentName="Student", Duration="12"),
        Lesson(Id = "3", DateTime = "2022-02-22", LessonType= "PartTime", StudentName="Student", Duration="12")
    )

    val students = mutableListOf(
        Student(Id = "1", Name = "Alex", Age= "12", PhoneNumber ="76788327883", Course="Math")
    )

    NavHost(navController = navController, startDestination = Screens.LessonsListScreen.route) {
        composable(Screens.LessonsListScreen.route) {
            LessonsList(
                lessons = lessons,
                onAddNewLessonClick = {
                    navController.navigate("addNewLesson")
                },
                onLessonClick = { lessonId ->
                    navController.navigate("detailedViewLesson/$lessonId")
                }
            )
        }

        composable(
            route = "addNewLesson"
        ) {
            AddNewLesson(
                onNewLessonAdded = { lesson ->
                    lessons.add(lesson)
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "editLesson/{lessonId}"
        ) {backStackEntry ->
            var lessonId = backStackEntry.arguments?.getString("lessonId")
            var currentElement = lessons.find { lesson -> lesson.Id == lessonId }
            var currentIndex = lessons.indexOf(currentElement)
            EditLesson(
                lesson = currentElement,
                onLessonEdited = { lesson ->
                    lessons.set(currentIndex, lesson)
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "detailedViewLesson/{lessonId}"
        ) { backStackEntry ->
            var lessonId = backStackEntry.arguments?.getString("lessonId")
            DetailedView(
                lesson = lessons.find { lesson -> lesson.Id == lessonId },
                onEditClick = {
                    navController.navigate("editLesson/$lessonId")
                },
                onDeleteClick = {
                    lessons.removeAt(lessons.indexOfFirst { it.Id == lessonId })
                    navController.popBackStack()
                }
            )
        }

        composable(Screens.StudentListScren.route) {
            StudentList(
                students = students,
                onAddNewStudentClick = {
                    navController.navigate("addNewStudent")
                },
                onStudentClick = { studentId ->
                    navController.navigate("detailedViewStudent/$studentId")
                }
            )
        }

        composable(
            route = "addNewStudent"
        ) {
            AddNewStudent(
                onNewStudentAdded = { student ->
                    students.add(student)
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "editStudent/{studentId}"
        ) {backStackEntry ->
            var studentId = backStackEntry.arguments?.getString("studentId")
            var currentElement = students.find { student -> student.Id == studentId }
            var currentIndex = students.indexOf(currentElement)
            EditStudent(
                student = currentElement,
                onStudentEdited = { student ->
                    students.set(currentIndex, student)
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "detailedViewStudent/{studentId}"
        ) { backStackEntry ->
            var studentId = backStackEntry.arguments?.getString("studentId")
            StudentDetailedView(
                student = students.find { student -> student.Id == studentId },
                onEditClick = {
                    navController.navigate("editStudent/$studentId")
                },
                onDeleteClick = {
                    students.removeAt(students.indexOfFirst { it.Id == studentId })
                    navController.popBackStack()
                }
            )
        }
    }
}