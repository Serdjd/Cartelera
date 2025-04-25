package com.example.cartelera.presentation.di

import com.example.cartelera.data.db.TMDBDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {

    @Provides
    fun movieDao(db: TMDBDataBase) = db.movieDao()

    @Provides
    fun artistDao(db: TMDBDataBase) = db.artistDao()

    @Provides
    fun tvShowDao(db: TMDBDataBase) = db.tvShowDao()
}