package com.example.holamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.holamundo.ui.theme.HolaMundoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolaMundoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InteractiveScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun InteractiveScreen(modifier: Modifier = Modifier) {
    var message by remember { mutableStateOf("¡Hola Mundo!") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            fontSize = 28.sp, // Tamaño reducido para que no se amontone
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E88E5),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center, // Centra el texto si ocupa 2 líneas
            lineHeight = 34.sp, // Le da espacio vertical entre líneas
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
        )

        Button(onClick = {
            message = "¡El Botón Funciona mi Hermano!"
        }) {
            Text(text = "Haz clic aquí", fontSize = 18.sp)
        }
    }
}