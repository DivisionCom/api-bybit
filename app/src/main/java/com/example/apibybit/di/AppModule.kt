package com.example.apibybit.di

import com.example.apibybit.data.remote.BybitApi
import com.example.apibybit.repository.BybitRepository
import com.example.apibybit.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideBybitRepository(api: BybitApi) = BybitRepository(api)

    @Singleton
    @Provides
    fun provideBybitApi(): BybitApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(BybitApi::class.java)
    }
}
