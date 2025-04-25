package com.example.cartelera.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cartelera.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<Artist>)

    @Query("DELETE FROM Artist")
    suspend fun deleteArtists()

    @Query("SELECT * FROM Artist")
    suspend fun getArtists() : List<Artist>

}