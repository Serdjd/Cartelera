package com.example.cartelera.presentation.di

import com.example.cartelera.data.repository.artist.ArtistDetailsRepositoryImpl
import com.example.cartelera.data.repository.artist.ArtistRepositoryImpl
import com.example.cartelera.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.cartelera.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.cartelera.data.repository.movie.MovieDetailsRepositoryImpl
import com.example.cartelera.data.repository.movie.MovieRepositoryImplementation
import com.example.cartelera.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.cartelera.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.cartelera.data.repository.tv.SeriesRepositoryImpl
import com.example.cartelera.data.repository.tv.TvShowRepositoryImpl
import com.example.cartelera.data.repository.tv.datasource.TvShowRemoteDataSource
import com.example.cartelera.data.repository.tv.datasourceimpl.TvShowRemoteDataSourceImpl
import com.example.cartelera.domain.repository.ArtistDetailsRepository
import com.example.cartelera.domain.repository.ArtistRepository
import com.example.cartelera.domain.repository.MovieDetailRepository
import com.example.cartelera.domain.repository.MovieRepository
import com.example.cartelera.domain.repository.SeriesRepository
import com.example.cartelera.domain.repository.TvShowRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppBindModule {

    @Binds
    abstract fun bindArtistRemoteDataSource(artistRemoteDataSource: ArtistRemoteDataSourceImpl): ArtistRemoteDataSource

    @Binds
    abstract fun bindMovieRemoteDataSource(movieRemoteDataSource: MovieRemoteDataSourceImpl): MovieRemoteDataSource

    @Binds
    abstract fun bindTvShowRemoteDataSource(tvShowRemoteDataSource: TvShowRemoteDataSourceImpl): TvShowRemoteDataSource

    @Binds
    abstract fun bindArtistRepository(artistRepository: ArtistRepositoryImpl): ArtistRepository
    @Binds
    abstract fun bindMovieRepository(movieRepository: MovieRepositoryImplementation): MovieRepository
    @Binds
    abstract fun bindTvShowRepository(tvShowRepository: TvShowRepositoryImpl): TvShowRepository
    @Binds
    abstract fun bindMovieDetailRepository(movieDetailRepository: MovieDetailsRepositoryImpl): MovieDetailRepository
    @Binds
    abstract fun bindArtistDetailsRepository(artistDetailsRepository: ArtistDetailsRepositoryImpl): ArtistDetailsRepository
    @Binds
    abstract fun bindSeriesRepository(seriesRepository: SeriesRepositoryImpl): SeriesRepository
}