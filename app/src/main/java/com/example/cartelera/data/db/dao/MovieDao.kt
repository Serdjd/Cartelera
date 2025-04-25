package com.example.cartelera.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cartelera.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM Movie")
    suspend fun deleteMovies()

    @Query("SELECT * FROM Movie")
    suspend fun getMovies() : List<Movie>

}