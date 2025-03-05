package com.example.pastillasapp.model.apidata

import Medicamentos


object MedicamentosRepository {
    suspend fun capturarMedicamento(nregistro: String): Medicamentos? {
        return try {
            val response = apiService.getMedicamento(nregistro)
            response // aqui estoy devolviendo response que no se te olvide
        } catch (e: Exception) {
            println("Error al obtener medicamento: ${e.message}")
            null
        }
    }
}
