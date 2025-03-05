package com.example.pastillasapp.model.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pastillasapp.R
import com.example.pastillasapp.view.screens.AmoxicilinaScreen
import com.example.pastillasapp.view.screens.LoginScreen
import com.example.pastillasapp.view.screens.ParacetamolScreen
import com.example.pastillasapp.view.screens.vista


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
            when(medicinaNombre.toString()){
                stringResource(id = R.string.paracetamol) ->  ParacetamolScreen(medicinaNombre.toString())
                stringResource(id = R.string.amoxicilina) ->  AmoxicilinaScreen(medicinaNombre.toString())
            }
        }
    }
}