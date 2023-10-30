package com.example.melitest.data

import com.example.melitest.model.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiMeli {

    @GET("/sites/MLA/search")
    suspend fun search(
        @Query("q") search: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): SearchResult
}