package com.example.cartelera.data.remote.api

import com.example.cartelera.BuildConfig
import com.example.cartelera.data.model.artist.detail.ArtistDetails
import com.example.cartelera.data.model.artist.ArtistList
import com.example.cartelera.data.model.movie.detail.MovieCredits
import com.example.cartelera.data.model.movie.detail.MovieDetails
import com.example.cartelera.data.model.movie.MovieList
import com.example.cartelera.data.model.tv.TvShowList
import com.example.cartelera.data.model.tv.detail.chapter.Season
import com.example.cartelera.data.model.tv.detail.SeriesDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int
    ): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int
    ): Response<ArtistList>

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<MovieDetails>


    @GET("movie/{id}/credits")
    suspend fun getMovieCredits(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<MovieCredits>

    @GET("person/{id}")
    suspend fun getArtistDetails(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<ArtistDetails>

    @GET("tv/{id}")
    suspend fun getSeriesDetails(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<SeriesDetails>

    @GET("tv/{id}/season/{season_number}")
    suspend fun getSeasonChapters(
        @Path("id") id: Int,
        @Path("season_number") seasonNumber: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<Season>
}