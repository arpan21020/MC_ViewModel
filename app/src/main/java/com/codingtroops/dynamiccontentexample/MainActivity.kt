package com.codingtroops.dynamiccontentexample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


val namesList: List<String> = listOf(
        "John",
        "Michael",
        "Andrew",
        "Danna",
        "Georgia")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//          GreetingList(names = namesList)
            MainScreen()
        }
    }
}


@Composable
fun MainScreen(viewmodel:MainViewModel=MainViewModel()  ){
    val newNameState= viewmodel.textFieldState.observeAsState("")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        GreetingList(newNameState.value,{newName->viewmodel.onTextChange(newName)})
    }
}
@Composable
fun GreetingList(textFieldValue:String,textFieldValueUpdate:(newVal:String)->Unit) {
    Column {
        TextField(value = textFieldValue, onValueChange =textFieldValueUpdate )
        Button(onClick = { }) {
            Text(text = textFieldValue)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    GreetingList(names = namesList)
    MainScreen()
}