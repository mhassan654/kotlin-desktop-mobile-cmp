package org.example.project.repositories

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow
import org.example.project.apiClient.httpClient
import org.example.project.data.Product

class HomeRepository {

    suspend fun getProductsApi(): List<Product>{
        val response = httpClient.get("https://fakestoreapi.com/products")
        return response.body();
    }

    fun getProducts()= flow { emit(getProductsApi()) }
}