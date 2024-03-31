package com.example.teachersapp.detailedView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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

@Composable
fun DetailedView(
    lessonId: String,
    viewModel: DetailedViewModel = DetailedViewModel(lessonId, LessonRepository())
){
    val lesson by viewModel.lessonLiveData.observeAsState()
    if (lesson != null) {
        Column (modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.bleak_yellow_light))
            .padding(16.dp)){
            DateTime(dateTime = lesson!!.DateTime)
            if (lesson!!.LessonType != null) {
                LessonType(lessonType = lesson!!.LessonType!!)
            }
            if (lesson!!.StudentName != null) {
                StudentName(studentName = lesson!!.StudentName!!)
            }
            MyDivider()
            Spacer(modifier = Modifier.height(16.dp))
            if (lesson!!.Duration != null) {
                Duration(duration = lesson!!.Duration!!)
            }

        }
    }
}
@Composable
fun DateTime(dateTime: String){
    Text(
        text = dateTime,
        color = Color.Black,
        fontSize = 15.sp,
        fontFamily = FontFamily.Serif,

        )

}
@Composable
fun LessonType(lessonType: String){
    Text(
        text = lessonType,
        color = Color.Black,
        fontSize = 15.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center



    )

}
@Composable
fun StudentName(studentName: String){
    Text(
        text = studentName,
        color = Color.Black,
        fontSize = 30.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center
    )
}
@Composable
fun Duration(duration: String){
    Text(
        text = duration,
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
