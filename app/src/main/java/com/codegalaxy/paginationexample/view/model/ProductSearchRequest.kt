package com.codegalaxy.paginationexample.view.model

import com.google.gson.annotations.SerializedName

data class ProductSearchRequest(
    @SerializedName("catgCd") val categoryCode: List<String>,
    @SerializedName("pageNo") val pageNumber: Int,
    @SerializedName("pageSize") val pageSize: Int
)