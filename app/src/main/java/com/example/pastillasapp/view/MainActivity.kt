package com.example.pastillasapp.view.theme

import Medicamentos
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pastillasapp.model.apidata.MedicamentosRepository
import com.example.pastillasapp.model.navegacion.NavigationWrapper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationWrapper()
        }
    }
}
@Composable
fun espaciador(num : Int){
    Spacer(modifier = Modifier.height(num.dp))
}
@Composable
fun detalles(nregistro: String) {
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 📌 Sección de detalles (Izquierda)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp)
            ) {
                Text(text = "Número de registro: ${medicina.nregistro}", style = MaterialTheme.typography.titleMedium)
                Text(text = "Nombre: ${medicina.nombre ?: "Desconocido"}")
                Text(text = "Laboratorio: ${medicina.labtitular ?: "Desconocido"}")
                espaciador(50)
                imagenesCoil(medicina.nregistro)
            }

            // 📌 Imagen del medicamento (Derecha)
        }
}


@Composable
fun imagenesCoil(codigo: String) {

    val codigos = mapOf(
        "77758" to "https://cima.aemps.es/cima/fotos/thumbnails/materialas/77758/77758_materialas.jpg",
        "67939" to "https://cima.aemps.es/cima/fotos/thumbnails/materialas/67939/67939_materialas.jpg",
        "78572" to "https://cima.aemps.es/cima/fotos/thumbnails/materialas/78572/78572_materialas.jpg",
        "68435" to "https://cima.aemps.es/cima/fotos/thumbnails/materialas/68435/68435_materialas.jpg",
        "62880" to "https://cima.aemps.es/cima/fotos/thumbnails/materialas/62880/62880_materialas.jpg"
    )

    val imagenUrl = codigos[codigo]


    if (imagenUrl != null) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imagenUrl)
                .build(),
            contentDescription = "Imagen del medicamento",
            modifier = Modifier
                .size(320.dp) // Ajusta el tamaño de la imagen
                .padding(8.dp)
        )
    } else {
        Text("No hay imagen", color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
    println("Cargando imagen para código: $codigo -> URL: $imagenUrl")
    println("supuesta url: $imagenUrl")

}


