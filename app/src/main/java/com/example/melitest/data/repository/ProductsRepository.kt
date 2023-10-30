package com.example.melitest.data.repository

import androidx.paging.PagingData
import com.example.melitest.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun search(query: String): Flow<PagingData<Product>>
}