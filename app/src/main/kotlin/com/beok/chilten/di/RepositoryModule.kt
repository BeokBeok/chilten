package com.beok.chilten.di

import com.beok.chilten.domain.ChiltenRemoteDataSource
import com.beok.chilten.domain.ChiltenRemoteDataSourceImpl
import com.beok.chilten.domain.ChiltenRepository
import com.beok.chilten.domain.ChiltenService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideChiltenRemoteDataSource(chiltenService: ChiltenService): ChiltenRemoteDataSource =
        ChiltenRemoteDataSourceImpl(chiltenService)

    @Provides
    @Singleton
    fun provideChiltenRepository(chiltenRemoteDataSource: ChiltenRemoteDataSource) =
        ChiltenRepository(chiltenRemoteDataSource)
}
