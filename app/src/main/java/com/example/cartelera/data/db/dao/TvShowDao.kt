package com.example.cartelera.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cartelera.data.model.tv.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShows: List<TvShow>)

    @Query("DELETE FROM TvShow")
    suspend fun deleteTvShows()

    @Query("SELECT * FROM TvShow")
    suspend fun getTvShows() : List<TvShow>

}