package com.example.teachersapp.addnew

import android.content.Intent
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teachersapp.ListActivity
import com.example.teachersapp.R
import com.example.teachersapp.data.network.LessonRepository
import com.example.teachersapp.models.Lesson
import java.time.Duration

@Composable
fun AddNewLesson(
    viewModel: AddNewLessonViewModel= AddNewLessonViewModel(LessonRepository())
){
    val context = LocalContext.current
    val id = remember {
        mutableStateOf("")
    }
    val studentName = remember {
        mutableStateOf("")
    }
    val lessonType = remember {
        mutableStateOf("")
    }
    val duration = remember {
        mutableStateOf("")
    }
    val dateTime = remember {
        mutableStateOf("")
    }
    val response by viewModel.insertResponseLiveData.observeAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            CreateNewLessonPageTitle()
            IdInput(id = id.value, onIdChange = { id.value = it })
            Spacer(Modifier.height(16.dp))
            StudentNameInput(
                studentName = studentName.value,
                onStudentNameChange = { studentName.value = it })
            Spacer(Modifier.height(16.dp))
            LessonTypeInput(
                lessonType = lessonType.value,
                onLessonTypeChange = { lessonType.value = it })
            Spacer(Modifier.height(16.dp))
            DurationTypeInput(
                duration = duration.value,
                onDurationChange = { duration.value = it })
            Spacer(Modifier.height(16.dp))
            DateTimeInput(
                dateTime = dateTime.value,
                onDateTimeChange = { dateTime.value = it })
            Spacer(Modifier.height(16.dp))


            AddNewButton {
                viewModel.SaveNewLesson(
                    Lesson(
                        id.value,
                        studentName.value,
                        lessonType.value,
                        dateTime.value,
                        duration.value

                    )
                )
            }
        }

        if (response != null) {
            Text(
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.Center),
                fontSize = 19.sp,
                text = if (response!!.status == "OK") stringResource(id = R.string.saved_success_msg)
                else stringResource(id = R.string.saved_fail_msg)
            )

            if (response!!.status == "OK") {
                context.startActivity(Intent(context, ListActivity::class.java))
            }
        }
    }

}
@Composable
private fun CreateNewLessonPageTitle() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(id = R.string.title_activity_add_new_lesson),
        color = Color.Black,
        fontSize = 26.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center
    )
}


@Composable
private fun IdInput(id: String, onIdChange: (String) -> Unit){
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = id,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onIdChange(it) },
        label = {
            Text(stringResource(id = R.string.lesson_id_input_hint))
        }
    )
}
@Composable
private fun StudentNameInput(studentName: String, onStudentNameChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = studentName,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onStudentNameChange(it) },
        label = {
            Text(stringResource(id = R.string.lesson_studentName_input_hint))
        }
    )
}
@Composable
private fun LessonTypeInput(lessonType: String, onLessonTypeChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = lessonType,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onLessonTypeChange(it) },
        label = {
            Text(stringResource(id = R.string.lesson_lessonType_input_hint))
        }
    )
}
@Composable
private fun DurationTypeInput(duration: String, onDurationChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = duration,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onDurationChange(it) },
        label = {
            Text(stringResource(id = R.string.lesson_duration_input_hint))
        }
    )
}

@Composable
private fun DateTimeInput(dateTime: String, onDateTimeChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = dateTime,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onDateTimeChange(it) },
        label = {
            Text(stringResource(id = R.string.lesson_datetime_input_hint))
        }
    )
}
@Composable
private fun AddNewButton(onClick: () -> Unit) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .padding(vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.bleak_yellow),
            contentColor = Color.Black
        )

    ) {
        Text(
            fontSize = 16.sp,
            text = stringResource(id = R.string.save_btn_text)
        )
    }
}

