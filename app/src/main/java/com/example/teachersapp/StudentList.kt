package com.example.teachersapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teachersapp.data.network.LessonRepository
import com.example.teachersapp.models.Lesson
import com.example.teachersapp.models.Student

@Composable
fun StudentList(

    students: List<Student>,
    onAddNewStudentClick: ()->Unit,
    onStudentClick: (String)-> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (!students.isNullOrEmpty()) {
            LazyColumn(modifier = Modifier
                .fillMaxHeight()
                .padding(20.dp, 20.dp, 20.dp, 90.dp)) {
                items(items = students!!.toList(), itemContent = { item ->
                    StudentItem(student = item, onStudentClick)
                })
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            FloatingActionButton(
                modifier = Modifier,
                containerColor = colorResource(id = R.color.bleak_yellow_light),
                onClick = onAddNewStudentClick
            ) {
                Text(
                    stringResource(id = R.string.btn_add_new_student),
                    modifier = Modifier.padding(15.dp, 5.dp),
                    fontFamily = FontFamily.Serif,
                    color = colorResource(id = R.color.black),
                    fontSize = 16.sp
                )
            }


        }
    }
}


@Composable
fun StudentItem(student: Student, onStudentClick: (String) -> Unit){
    ElevatedCard(
        modifier = Modifier
            .padding(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.teal_200), //Card background color
            contentColor = Color.DarkGray  //Card content color,e.g.text
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    )
    {
        Column(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clickable {
                    onStudentClick(student.Id)
                }
        ) {
            StudentItemName(name = student.Name)
            StudentItemDesc(desc = student.Course)
        }
    }

}
@Composable
fun StudentItemName(name: String){
    Text(
        text = name,
        color = Color.Black,
        fontSize = 10.sp,
        fontFamily = FontFamily.Serif

    )

}
@Composable
fun StudentItemDesc(desc: String){
    Text(
        text = desc,
        color = Color.White,
        fontSize = 10.sp,
        fontFamily = FontFamily.Serif

    )

}
