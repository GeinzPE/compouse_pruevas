package com.composable.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.composable.myapplication.ui.theme.MiPrimerComposableTheme
import com.composable.myapplication.ui.theme.boxs.boxces
import com.composable.myapplication.ui.theme.constrain_layout.constraint
import com.composable.myapplication.ui.theme.constrain_layout.tarea

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiPrimerComposableTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    tarea(Modifier.padding())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiPrimerComposableTheme {
        Greeting("Android")
    }
}