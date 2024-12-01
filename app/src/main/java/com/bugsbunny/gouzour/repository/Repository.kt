package com.bugsbunny.gouzour.repository

import com.bugsbunny.gouzour.model.ProductDetailsDto
import com.bugsbunny.gouzour.util.ApiState

interface Repository {
    suspend fun getProductDetails(): ApiState<ProductDetailsDto>
}