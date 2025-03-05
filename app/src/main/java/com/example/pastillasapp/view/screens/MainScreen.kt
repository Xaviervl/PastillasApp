package com.example.pastillasapp.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pastillasapp.R
import com.example.pastillasapp.view.theme.espaciador


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun vista(navController: NavController) {
    Scaffold(
        topBar = { top() },
        content = { paddingValues ->
            LazyColumn( // Se agrega un lazycolumn ya que si en el caso de que los componentes superen el tamaño de la pantalla se pueda desplazar hacia abajo
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                item {
                    carrusel(navController)
                }

                item {
                    espaciador(55)
                }

                item {
                    comentarios()
                }
            }
        }
    )
}

@Composable
fun carrusel(navController: NavController) {
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
            val medicinaNombre = stringResource(id = nombres[index])
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("detalle/$medicinaNombre")
                    }
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
            label = { Text(text = stringResource(id = R.string.label1)) },
            placeholder = { Text(text = stringResource(id = R.string.placeholder1)) },
            singleLine = true
        )
        espaciador(10)
        Button(onClick = {
            coment = state },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.verde)
            ))
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