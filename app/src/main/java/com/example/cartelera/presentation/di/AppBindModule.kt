package com.example.cartelera.presentation.di

import com.example.cartelera.data.repository.artist.ArtistRepositoryImpl
import com.example.cartelera.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.cartelera.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.cartelera.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.cartelera.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.example.cartelera.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.example.cartelera.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.cartelera.data.repository.movie.MovieRepositoryImplementation
import com.example.cartelera.data.repository.movie.datasource.MovieCacheDataSource
import com.example.cartelera.data.repository.movie.datasource.MovieLocalDataSource
import com.example.cartelera.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.cartelera.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.example.cartelera.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.example.cartelera.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.cartelera.data.repository.tv.TvShowRepositoryImpl
import com.example.cartelera.data.repository.tv.datasource.TvShowCacheDataSource
import com.example.cartelera.data.repository.tv.datasource.TvShowLocalDataSource
import com.example.cartelera.data.repository.tv.datasource.TvShowRemoteDataSource
import com.example.cartelera.data.repository.tv.datasourceimpl.TvShowCacheDataSourceImpl
import com.example.cartelera.data.repository.tv.datasourceimpl.TvShowLocalDataSourceImpl
import com.example.cartelera.data.repository.tv.datasourceimpl.TvShowRemoteDataSourceImpl
import com.example.cartelera.domain.repository.ArtistRepository
import com.example.cartelera.domain.repository.MovieRepository
import com.example.cartelera.domain.repository.TvShowRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppBindModule {

    @Binds
    abstract fun bindArtistCacheDataSource(artistCacheDataSource: ArtistCacheDataSourceImpl): ArtistCacheDataSource
    @Binds
    abstract fun bindArtistLocalDataSource(artistLocalDataSource: ArtistLocalDataSourceImpl): ArtistLocalDataSource
    @Binds
    abstract fun bindArtistRemoteDataSource(artistRemoteDataSource: ArtistRemoteDataSourceImpl): ArtistRemoteDataSource

    @Binds
    abstract fun bindMovieCacheDataSource(movieCacheDataSource: MovieCacheDataSourceImpl): MovieCacheDataSource
    @Binds
    abstract fun bindMovieLocalDataSource(movieLocalDataSource: MovieLocalDataSourceImpl): MovieLocalDataSource
    @Binds
    abstract fun bindMovieRemoteDataSource(movieRemoteDataSource: MovieRemoteDataSourceImpl): MovieRemoteDataSource

    @Binds
    abstract fun bindTvShowCacheDataSource(tvShowCacheDataSource: TvShowCacheDataSourceImpl): TvShowCacheDataSource
    @Binds
    abstract fun bindTvShowLocalDataSource(tvShowLocalDataSource: TvShowLocalDataSourceImpl): TvShowLocalDataSource
    @Binds
    abstract fun bindTvShowRemoteDataSource(tvShowRemoteDataSource: TvShowRemoteDataSourceImpl): TvShowRemoteDataSource

    @Binds
    abstract fun bindArtistRepository(artistRepository: ArtistRepositoryImpl): ArtistRepository
    @Binds
    abstract fun bindMovieRepository(movieRepository: MovieRepositoryImplementation): MovieRepository
    @Binds
    abstract fun bindTvShowRepository(tvShowRepository: TvShowRepositoryImpl): TvShowRepository

}