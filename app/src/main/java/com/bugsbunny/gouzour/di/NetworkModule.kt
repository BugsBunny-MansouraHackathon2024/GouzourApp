package com.bugsbunny.gouzour.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.bugsbunny.gouzour.BuildConfig
import com.bugsbunny.gouzour.network.ApiService
import com.bugsbunny.gouzour.repository.Repository
import com.bugsbunny.gouzour.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providesOkHttpClient(@ApplicationContext context: Context): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(context))
            .build()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): ApiService = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(
            Json.asConverterFactory(
            "application/json; charset=UTF8".toMediaType()))
        .client(okHttpClient)
        .build()
        .create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesRepository(apiService: ApiService): Repository = RepositoryImpl(apiService)
}