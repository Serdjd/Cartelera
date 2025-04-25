package com.example.cartelera.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.cartelera.BuildConfig
import com.example.cartelera.data.api.TMDBService
import com.example.cartelera.data.db.TMDBDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun client() = OkHttpClient.Builder()
        .addInterceptor(
            object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    return chain.proceed(
                        chain.request()
                            .newBuilder()
                            .header("accept", "application/json")
                            .header("Authorization", BuildConfig.HEADER_AUTH)
                            .build()
                    )
                }
            }
        ).build()

    @Provides
    @Singleton
    fun retrofit(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    @Provides
    @Singleton
    fun tmdmApi(retrofit: Retrofit) = retrofit.create(TMDBService::class.java)

    @Provides
    @Singleton
    fun db(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        TMDBDataBase::class.java, "cartelera"
    ).build()
}