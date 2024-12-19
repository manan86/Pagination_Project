package com.codegalaxy.paginationexample.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.codegalaxy.paginationexample.view.model.repository.IProductRepository
import com.codegalaxy.paginationexample.view.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: IProductRepository
) : ViewModel() {

    val products: Flow<PagingData<Product>> = repository.getProductsFlow().cachedIn(viewModelScope)
}
