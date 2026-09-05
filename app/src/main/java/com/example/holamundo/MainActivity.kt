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
// Asegúrate de tener estas importaciones adicionales en la parte superior:
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource

@Composable
fun InteractiveScreen(modifier: Modifier = Modifier) {
    // Variable para controlar el estado
    var isOriginalText by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Texto principal
        Text(
            text = if (isOriginalText) "¡Hola Vicente!" else "¡El Botón Funciona mi Hermano!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE53935), // Tu color rojo actual
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            lineHeight = 36.sp,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
        )

        // LA IMAGEN SOLO APARECE CUANDO SE PRESIONA EL BOTÓN
        if (!isOriginalText) {
            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.perro),
                contentDescription = "Foto de perrito",
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 16.dp)
            )
        }

        // Botón
        Button(onClick = {
            isOriginalText = !isOriginalText
        }) {
            Text(
                text = if (isOriginalText) "Haz clic aquí" else "Volver inicio",
                fontSize = 18.sp
            )
        }
    }
}