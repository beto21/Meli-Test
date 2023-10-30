package com.example.melitest.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.melitest.model.Product

class MoviePagingSource(
    private val apiMeli: ApiMeli,
    private val query: String
) : PagingSource<Int, Product>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        return try {
            val nextPage = params.key ?: 1
            val response = apiMeli.search(query, nextPage, 10)
            LoadResult.Page(
                data = response.products,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = response.paging.offset + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)

        }
    }

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}