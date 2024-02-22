package com.ekremkocak.nfcreader.dij


import com.ekremkocak.nfcreader.util.Constansts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Singleton
    @Provides
    fun getRetrofitServiceInstance(retrofit: Retrofit): RetrofitServiceInstance
    {
        return retrofit.create(RetrofitServiceInstance::class.java)
    }


    @Singleton
    @Provides
    fun getRetrofitInstance() : Retrofit
    {
        return  Retrofit.Builder()
            .baseUrl(Constansts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}