package com.example.teachersapp.navigation

sealed class Screens(val route: String) {
    object LessonsListScreen: Screens("lessons_list")

}