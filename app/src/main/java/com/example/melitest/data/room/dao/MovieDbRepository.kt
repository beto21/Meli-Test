package com.example.melitest.data.room.dao

import com.example.melitest.model.Product


interface MovieDbRepository {

    fun findMovieById(id: Int): Product?

    fun insertMovie(product: Product)

    fun insertMovies(products: List<Product>)

    fun findMovies(): List<Product>

    fun updateMovie(product: Product)

    fun deleteMovie(product: Product)

    fun deleteMovies(products: List<Product>)


}