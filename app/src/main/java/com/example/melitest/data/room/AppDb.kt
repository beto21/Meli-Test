package com.example.melitest.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.melitest.data.room.dao.MovieDao
import com.example.melitest.model.Product

@Database(
    entities =
    [Product::class], version = 1, exportSchema = false
)


abstract class AppDb : RoomDatabase() {
    abstract val productDao: MovieDao

}