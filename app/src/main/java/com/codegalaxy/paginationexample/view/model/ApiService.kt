package com.codegalaxy.paginationexample.view.model

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("crm-common/api/common/msil/partmaster/search-product-list")
    suspend fun getProducts(
        @Body request: ProductSearchRequest
    ): ProductResponse
}