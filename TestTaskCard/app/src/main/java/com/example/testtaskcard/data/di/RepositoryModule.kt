package com.example.testtaskcard.data.di

import com.example.testtaskcard.data.binListApi.repository.BinListRepository
import com.example.testtaskcard.data.binListApi.repository.IBinListRepository
import com.example.testtaskcard.data.dataBase.repository.CardInfoRepository
import com.example.testtaskcard.data.dataBase.repository.ICardInfoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBinListRepository(repository: BinListRepository) : IBinListRepository

    @Binds
    @Singleton
    abstract fun bindCardInfoRepository(repository: CardInfoRepository) : ICardInfoRepository

}