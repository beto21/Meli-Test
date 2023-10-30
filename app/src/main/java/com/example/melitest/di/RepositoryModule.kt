package com.example.melitest.di

import com.example.melitest.data.ApiMeli
import com.example.melitest.data.repository.ProductsRepository
import com.example.melitest.data.repository.impl.ProductsRepositoryImpl
import com.example.melitest.data.room.AppDb
import com.example.melitest.utils.network.ConnectionProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepositoryMovie(
        db: AppDb,
        api: ApiMeli,
        connectionProvider: ConnectionProvider,

        ): ProductsRepository {
        return ProductsRepositoryImpl(api, db, connectionProvider)
    }

}