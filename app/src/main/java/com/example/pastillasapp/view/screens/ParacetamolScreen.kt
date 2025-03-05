package com.example.pastillasapp.view.screens

import Medicamentos
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pastillasapp.model.apidata.MedicamentosRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParacetamolScreen(medicinaNombre: String) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Detalles del Medicamento") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = medicinaNombre.ifEmpty { "Medicamento no encontrado" },
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )
            pastillas("51347") // Ahora está dentro de la Column correctamente
        }
    }
}


@Composable
fun pastillas(nregistro: String) {
    var medicamento by remember { mutableStateOf<Medicamentos?>(null) }
    var loading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    LaunchedEffect(nregistro) {
        loading = true
        try {
            val resultado = MedicamentosRepository.capturarMedicamento(nregistro)
            if (resultado != null) {
                medicamento = resultado
            } else {
                errorMessage = "No se encontró el medicamento con nregistro: $nregistro"
            }
        } catch (e: Exception) {
            errorMessage = "Error: ${e.message}"
        } finally {
            loading = false
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        when {
            loading -> CircularProgressIndicator()
            errorMessage.isNotEmpty() -> Text(errorMessage, color = MaterialTheme.colorScheme.error)
            medicamento != null -> medicinaItem(medicamento!!)
        }
    }
}

@Composable
fun medicinaItem(medicina: Medicamentos) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Número de registro: ${medicina.nregistro}")
            Text(text = "Nombre: ${medicina.nombre ?: "Desconocido"}")
            Text(text = "Laboratorio: ${medicina.labtitular ?: "Desconocido"}")
        }
    }
}




