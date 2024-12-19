package com.codegalaxy.paginationexample.view.model.repository

import androidx.paging.PagingData
import com.codegalaxy.paginationexample.view.model.Product
import kotlinx.coroutines.flow.Flow

interface IProductRepository {
    fun getProductsFlow(): Flow<PagingData<Product>>
}