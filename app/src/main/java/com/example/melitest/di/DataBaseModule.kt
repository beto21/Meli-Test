package com.example.melitest.di

import android.app.Application
import androidx.room.Room
import com.example.melitest.BuildConfig
import com.example.melitest.data.room.AppDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(
        app: Application,
    ) = Room.databaseBuilder(app, AppDb::class.java, BuildConfig.DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()


}