package com.example.pastillasapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun LoginScreen(navigatetoMain : () -> Unit){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment =  Alignment.CenterHorizontally) {
        espaciador(250)
        Text( text = stringResource(id = R.string.login), fontSize = 25.sp)
        espaciador(30)
        Button(onClick = {navigatetoMain()}) {
            Text(text = "Navegar")
        }
        espaciador(100)
        Text( text = stringResource(id = R.string.loginad), fontSize = 15.sp, fontWeight = FontWeight.Bold)
    }
}