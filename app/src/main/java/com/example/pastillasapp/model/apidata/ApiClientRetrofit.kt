package com.example.pastillasapp.model.apidata

import Medicamentos
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiClientRetrofit {
    @GET("medicamento") // Sin el "?" al final
    suspend fun getMedicamento(
        @Query("nregistro") nregistro: String
    ): Medicamentos
}


val retrofit = Retrofit.Builder()
    .baseUrl("https://cima.aemps.es/cima/rest/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val apiService = retrofit.create(ApiClientRetrofit::class.java)