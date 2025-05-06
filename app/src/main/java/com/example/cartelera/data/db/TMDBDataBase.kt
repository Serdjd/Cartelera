package com.example.cartelera.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cartelera.data.db.dao.ArtistDao
import com.example.cartelera.data.db.dao.MovieDao
import com.example.cartelera.data.db.dao.TvShowDao
import com.example.cartelera.data.model.artist.Artist
import com.example.cartelera.data.model.movie.Movie
import com.example.cartelera.data.model.tv.TvShow

@Database(
    entities = [
        Artist::class,
        Movie::class,
        TvShow::class
    ],
    version = 1,
    exportSchema = false
)
abstract class TMDBDataBase: RoomDatabase() {
    abstract fun artistDao(): ArtistDao
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
}