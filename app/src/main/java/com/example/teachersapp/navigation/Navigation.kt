package com.example.teachersapp.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.teachersapp.LessonsList
import com.example.teachersapp.addnew.AddNewLesson
import com.example.teachersapp.detailedView.DetailedView
import com.example.teachersapp.edtiLesson.EditLesson
import com.example.teachersapp.models.Lesson

@Composable
fun Navigation(navController: NavHostController) {
    val lessons = mutableListOf(
        Lesson(Id = "1", DateTime = "2022-02-22", LessonType= "PartTime", StudentName="Student", Duration="12"),
        Lesson(Id = "2", DateTime = "2022-02-22", LessonType= "PartTime", StudentName="Student", Duration="12"),
        Lesson(Id = "3", DateTime = "2022-02-22", LessonType= "PartTime", StudentName="Student", Duration="12")
    );

    NavHost(navController = navController, startDestination = Screens.LessonsListScreen.route) {
        composable(Screens.LessonsListScreen.route) {
            LessonsList(
                lessons = lessons,
                onAddNewLessonClick = {
                    navController.navigate("addNew")
                }, onLessonClick = { lessonId ->
                    navController.navigate("detailedView/$lessonId")
                }
            )
        }

        composable(
            route = "addNew"
        ) {
            AddNewLesson(
                onNewLessonAdded = { lesson ->
                    lessons.add(lesson);
                    navController.navigate(Screens.LessonsListScreen.route)
                }
            )
        }

        composable(
            route = "edit/{lessonId}"
        ) {backStackEntry ->
            var lessonId = backStackEntry.arguments?.getString("lessonId");
            var currentElement = lessons.find { lesson -> lesson.Id == lessonId}
            var currentIndex = lessons.indexOf(currentElement);
            EditLesson(
                lesson = currentElement,
                onLessonEdited = { lesson ->
                    lessons.set(currentIndex, lesson);
                    navController.navigate("detailedView/$lessonId")
                }
            )
        }

        composable(
            route = "detailedView/{lessonId}"
        ) { backStackEntry ->
            var lessonId = backStackEntry.arguments?.getString("lessonId");
            DetailedView(
                lesson = lessons.find { lesson -> lesson.Id == lessonId},
                onEditClick = {
                    navController.navigate("edit/$lessonId")
                },
                onDeleteClick = {
                    lessons.removeAt(lessons.indexOf(lessons.find { lesson -> lesson.Id == lessonId}))
                    navController.navigate(Screens.LessonsListScreen.route)
                }
            )
        }
    }
}