package com.example.pastillasapp.model.apidata

import Medicamentos


object MedicamentosRepository {
    suspend fun capturarMedicamento(nregistro: String): Medicamentos? {
        return try {
            val response = apiService.getMedicamento(nregistro)
            println("Medicamento encontrado: $response") // Imprime la respuesta para verificar
            response
        } catch (e: Exception) {
            println("Error al obtener medicamento: ${e.message}")
            null
        }
    }
}
