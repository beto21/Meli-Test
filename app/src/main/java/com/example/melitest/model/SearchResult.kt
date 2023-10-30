package com.example.melitest.model

import com.google.gson.annotations.SerializedName

data class SearchResult(
    val country_default_time_zone: String,
    val filters: List<Any>,
    val paging: Paging,
    val query: String,
    @SerializedName("results")
    val products: List<Product>,
    val site_id: String,
)