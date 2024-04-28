package com.example.teachersapp.detailedViewStudent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teachersapp.R
import com.example.teachersapp.data.network.LessonRepository
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import com.example.teachersapp.models.Lesson
import com.example.teachersapp.models.Student

@Composable
fun StudentDetailedView(
    student: Student?,
    onDeleteClick: () -> Unit,
    onEditClick: () -> Unit
){
    if (student != null) {
        Column (modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.bleak_yellow_light))
            .padding(16.dp)){
            Name(name = student!!.Name)
            if (student!!.Course != null) {
                Course(course = student!!.Course!!)
            }
            if (student!!.PhoneNumber != null) {
                PhoneNumber(phoneNumber = student!!.PhoneNumber!!)
            }
            MyDivider()
            Spacer(modifier = Modifier.height(16.dp))
            if (student!!.Age != null) {
                Age(age = student!!.Age!!)
            }
            Row() {
                Button(onClick = { onDeleteClick() }) {
                    Text("Delete")
                }
                Button(onClick = { onEditClick() }) {
                    Text("Edit")
                }
            }
        }
    }
}
@Composable
fun Name(name: String){
    Text(
        text = name,
        color = Color.Black,
        fontSize = 15.sp,
        fontFamily = FontFamily.Serif,

        )

}
@Composable
fun Course(course: String){
    Text(
        text = course,
        color = Color.Black,
        fontSize = 15.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center



    )

}
@Composable
fun PhoneNumber(phoneNumber: String){
    Text(
        text = phoneNumber,
        color = Color.Black,
        fontSize = 30.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center
    )
}
@Composable
fun Age(age: String){
    Text(
        text = age,
        color = Color.Black,
        fontSize = 15.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun MyDivider() {
    Divider(
        color = Color.LightGray
    )
}
