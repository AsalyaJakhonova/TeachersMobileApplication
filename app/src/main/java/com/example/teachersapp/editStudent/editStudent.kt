package com.example.teachersapp.editStudent

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
import com.example.teachersapp.models.Student
import java.time.Duration

@Composable
fun EditStudent(
    student: Student?,
    onStudentEdited: (Student) -> Unit,
){
    if (student != null) {
        val id = remember {
            mutableStateOf(student.Id)
        }
        val name = remember {
            mutableStateOf(student.Name)
        }
        val age = remember {
            mutableStateOf(student.Age)
        }
        val phoneNumber = remember {
            mutableStateOf(student.PhoneNumber)
        }
        val course = remember {
            mutableStateOf(student.Course)
        }

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                EditStudentPageTitle()
                IdInput(id = id.value, onIdChange = { id.value = it })
                Spacer(Modifier.height(16.dp))
                NameInput(
                    name = name.value,
                    onNameChange = { name.value = it })
                Spacer(Modifier.height(16.dp))
                AgeInput(
                    age = age.value,
                    onAgeChange = { age.value = it })
                Spacer(Modifier.height(16.dp))
                PhoneNumberInput(
                    phoneNumber = phoneNumber.value,
                    onPhoneNumberChange = { phoneNumber.value = it })
                Spacer(Modifier.height(16.dp))
                CourseInput(
                    course = course.value,
                    onCourseChange = { course.value = it })
                Spacer(Modifier.height(16.dp))


                AddNewButton {
                    onStudentEdited(
                        Student(
                            id.value,
                            name.value,
                            age.value,
                            phoneNumber.value,
                            course.value
                        )
                    )
                }
            }
        }
    }
}
@Composable
private fun EditStudentPageTitle() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(id = R.string.title_activity_edit_student),
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
            Text(stringResource(id = R.string.studentedit_id_input_hint))
        }
    )
}
@Composable
private fun NameInput(name: String, onNameChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = name,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onNameChange(it) },
        label = {
            Text(stringResource(id = R.string.studentedit_Name_input_hint))
        }
    )
}
@Composable
private fun AgeInput(age: String, onAgeChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = age,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onAgeChange(it) },
        label = {
            Text(stringResource(id = R.string.studentedit_age_input_hint))
        }
    )
}
@Composable
private fun PhoneNumberInput(phoneNumber: String, onPhoneNumberChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = phoneNumber,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onPhoneNumberChange(it) },
        label = {
            Text(stringResource(id = R.string.studentedit_phoneNumber_input_hint))
        }
    )
}

@Composable
private fun CourseInput(course: String, onCourseChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = course,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onCourseChange(it) },
        label = {
            Text(stringResource(id = R.string.studentedit_course_input_hint))
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

