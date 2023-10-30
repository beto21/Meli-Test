package com.example.melitest.data.repository.impl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.melitest.data.ApiMeli
import com.example.melitest.data.MoviePagingSource
import com.example.melitest.data.repository.ProductsRepository
import com.example.melitest.data.room.AppDb
import com.example.melitest.model.Product
import com.example.melitest.utils.network.ConnectionProvider
import kotlinx.coroutines.flow.Flow

class ProductsRepositoryImpl(
    private val api: ApiMeli,
    db: AppDb,
    connectionProvider: ConnectionProvider,
) : ProductsRepository {
    override fun search(query: String): Flow<PagingData<Product>> {
        val pagingConfig = PagingConfig(pageSize = 1)
        val pager = Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                MoviePagingSource(api, query)
            }, initialKey = 1
        )
        return pager.flow
    }
}