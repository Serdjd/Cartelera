package com.example.cartelera.data.repository.movie

import android.util.Log
import com.example.cartelera.data.model.movie.Movie
import com.example.cartelera.data.repository.movie.datasource.MovieCacheDataSource
import com.example.cartelera.data.repository.movie.datasource.MovieLocalDataSource
import com.example.cartelera.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.cartelera.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImplementation @Inject constructor(
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
): MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val movies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDb(movies)
        movieCacheDataSource.saveMoviesToCache(movies)
        return movies
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (e: Exception) {
            Log.e("INFO",e.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (e: Exception) {
            Log.i("INFO",e.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDb(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        var movieList = movieCacheDataSource.getMoviesFromCache()
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}