package com.codegalaxy.paginationexample.view.model

data class ProductData(
    val TOTAL_PAGES: Int,
    val TOTAL_RECORDS: Int,
    val CURRENT_PAGE_NO: Int,
    val PRODUCT_LIST: List<Product>
)
