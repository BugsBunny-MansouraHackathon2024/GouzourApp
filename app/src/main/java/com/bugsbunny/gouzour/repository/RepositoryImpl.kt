package com.bugsbunny.gouzour.repository

import com.bugsbunny.gouzour.model.ProductDetailsDto
import com.bugsbunny.gouzour.network.ApiService
import com.bugsbunny.gouzour.util.ApiState
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {

    override suspend fun getProductDetails(): ApiState<ProductDetailsDto> = try {
        ApiState.Success(apiService.getProductDetails())
    } catch (e: Exception) {
        ApiState.Error(errorMsg = e.message.toString())
    }
}