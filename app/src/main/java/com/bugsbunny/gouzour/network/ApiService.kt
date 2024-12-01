package com.bugsbunny.gouzour.network

import com.bugsbunny.gouzour.model.ProductDetailsDto
import retrofit2.http.GET

interface ApiService {

    @GET("products/1") // TODO: Set API Endpoint
    suspend fun getProductDetails(): ProductDetailsDto // TODO: Set API Response
}