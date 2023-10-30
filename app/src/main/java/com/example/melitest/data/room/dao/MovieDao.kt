package com.example.melitest.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.melitest.model.Product

@Dao
interface MovieDao : BaseDao<Product> {

    @Transaction
    @Query("SELECT * FROM product ")
    suspend fun findAll(): List<Product>

    @Transaction
    @Query("SELECT * FROM product WHERE id = :id LIMIT 1")
    suspend fun findById(id: String): Product?
}



