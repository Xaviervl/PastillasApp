package com.example.pastillasapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            vista()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun vista() {
    Scaffold(
        topBar = { top() },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                carrusel()
                espaciador(55)
                comentarios()
            }
        }
    )
}

@Composable
fun carrusel() {
    val imagenes = listOf(
        R.drawable.paracetamol,
        R.drawable.ibuprofeno,
        R.drawable.pildora,
        R.drawable.naproxeno,
        R.drawable.amoxicilina,
    )
    val nombres = listOf(
        R.string.paracetamol,
        R.string.ibuprofeno,
        R.string.pildora,
        R.string.naproxeno,
        R.string.amoxicilina,
    )
    LazyRow(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(5) { index ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = imagenes[index]),
                        contentDescription = null,
                        modifier = Modifier.size(200.dp).align(Alignment.Start)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(id = nombres[index]),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun top() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.verde)
        ),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 8.dp)
                )

                Text(
                    text = stringResource(id = R.string.beta),
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center
                )

                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    )
}

@Composable
fun comentarios(){
    var state by remember { mutableStateOf("") }
    var coment by remember { mutableStateOf("") }
        Column {
            Text(text = stringResource(id = R.string.texto1), fontSize = 16.sp)
            espaciador(5)
            OutlinedTextField( value = state, onValueChange = { state = it},
                label = { Text(text = stringResource(id = R.string.label1))},
                placeholder = { Text(text = stringResource(id = R.string.placeholder1))},
                singleLine = true
            )
            espaciador(10)
            Button(onClick = {
                coment = state },
                colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.verde)))
            {
                Text(text = "Click")
            }
            espaciador(15)
            texto(coment)
        }
}

@Composable
fun texto(com : String){
    Text(
        text = stringResource(id = R.string.p1)
    )
    Text(
        text = stringResource(id = R.string.p2),
        fontWeight = FontWeight.Bold
    )
    Text(
        text = stringResource(id = R.string.p2_1)
    )
    Text(
        text = stringResource(id = R.string.p3),
        fontWeight = FontWeight.Bold
    )
    Text(
        text = stringResource(id = R.string.p3_1)
    )
    Text(
        text = stringResource(id = R.string.p4),
        fontWeight = FontWeight.Bold
    )
    Text(
        text = "-" + com
    )
}

@Composable
fun espaciador(num : Int){
    Spacer(modifier = Modifier.height(num.dp))
}
