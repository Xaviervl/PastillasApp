package com.example.pastillasapp.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pastillasapp.DetallePantalla
import com.example.pastillasapp.LoginScreen
import com.example.pastillasapp.vista


@Composable
fun NavigationWrapper(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login ){
        composable<Login> {
            LoginScreen {
                navController.navigate(Main)
            }
        }
        composable<Main> {
            vista(navController)
        }
        composable("detalle/{medicinaNombre}") { backStackEntry ->
            val medicinaNombre = backStackEntry.arguments?.getString("medicinaNombre") // Obtener parámetro
            DetallePantalla(medicinaNombre.toString()) //  Pasar el nombre a la pantalla de detalles
        }
    }
}