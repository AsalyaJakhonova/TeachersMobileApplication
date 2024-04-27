package com.example.teachersapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.example.teachersapp.navigation.Navigation
import com.example.teachersapp.navigation.Screens
import com.example.teachersapp.ui.theme.TeachersAppTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var context = this;
            TeachersAppTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                NavigationBar() {
                                    NavigationBarItem(
                                        icon = {
                                            Icon(
                                                Icons.Filled.List,
                                                contentDescription = "Lessons"
                                            )
                                        },
                                        label = { Text(text = "Lessons") },
                                        selected = false,
                                        onClick = {
                                            navController.navigate(Screens.LessonsListScreen.route);
                                        },
                                    )
                                    NavigationBarItem(
                                        icon = {
                                            Icon(
                                                Icons.Filled.Add,
                                                contentDescription = "Add Lesson"
                                            )
                                        },
                                        label = { Text(text = "Add Lesson") },
                                        selected = false,
                                        onClick = {
                                            navController.navigate("addNew");
                                        },
                                    )
                                    NavigationBarItem(
                                        icon = {
                                            Icon(
                                                Icons.Filled.Share,
                                                contentDescription = "Upload Icon"
                                            )
                                        },
                                        label = { Text(text = "Upload File") },
                                        selected = false,
                                        onClick = {
                                            context.startActivity(Intent(context, MainActivity::class.java))
                                        },
                                    )
                                }
                            }
                        }
                    ) { padding ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth().padding(padding)
                        ) {
                            Navigation(navController = navController)

                            navController.navigate(Screens.LessonsListScreen.route)
                        }
                    }
                }
            }
        }
    }
}

