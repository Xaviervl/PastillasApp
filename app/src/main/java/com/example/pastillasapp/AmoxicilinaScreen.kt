package com.example.pastillasapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AmoxicilinaScreen(nombre: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // 🔥 Centra todo el contenido de la Box
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // 🔥 Centra los elementos dentro de la Column
            verticalArrangement = Arrangement.Center // 🔥 Opcional si quieres que crezca en altura
        ) {
            Text(text = "SOY LA AMOXICILINA")
        }
    }
}
