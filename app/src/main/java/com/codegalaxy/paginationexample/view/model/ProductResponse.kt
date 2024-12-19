package com.codegalaxy.paginationexample.view.model

data class ProductResponse(
    val error: Boolean,
    val errors: Any?,
    val data: ProductData
)
