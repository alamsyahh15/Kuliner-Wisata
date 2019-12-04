package com.udacoding.kulinerdanwisata.network

import com.udacoding.kulinerdanwisata.model.ResultWisata
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object NetworkConfig {

    private fun getInterceptor() : OkHttpClient{
       val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()
    }

    private fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://udacoding.com/api/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    fun service() : NetworkService = getRetrofit().create(NetworkService::class.java)
}

interface NetworkService {
    @GET("?action=findAll")
    fun getWisata(): Call<ResultWisata>
}