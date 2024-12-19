package com.codegalaxy.paginationexample.view.model

data class Product(
    val THUMBNAIL_IMAGE_URL: String,
    val PART_NAME: String,
    val PART_NUM: String,
    val PART_MRP: Double,
    val CATG_TYPE: String,
    val UNIT: String,
    val QTY: Int,
    val UNIT_RATE: Double,
    val ADDRESS: String,
    val OUT_OF_STOCK: String
)

