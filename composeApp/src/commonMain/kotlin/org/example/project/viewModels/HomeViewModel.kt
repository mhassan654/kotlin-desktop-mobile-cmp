package org.example.project.viewModels

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.data.Product
import org.example.project.repositories.HomeRepository

class HomeViewModel: ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(listOf())
    val products = _products.asStateFlow();

    private val homeRepository = HomeRepository()

    init {
        viewModelScope.launch {
            homeRepository.getProducts().collect{products->
            _products.update { it + products }}
        }
    }
}