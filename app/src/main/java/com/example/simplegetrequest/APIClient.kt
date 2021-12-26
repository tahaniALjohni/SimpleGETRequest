package com.example.simplegetrequest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    fun getClient(): Retrofit?{
        var retrofit : Retrofit? = null
        retrofit = Retrofit.Builder()
            .baseUrl("https://dojo-recipes.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}