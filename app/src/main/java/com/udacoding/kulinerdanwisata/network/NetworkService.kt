package com.udacoding.kulinerdanwisata.network

import com.udacoding.kulinerdanwisata.model.ResultWisata
import retrofit2.Call
import retrofit2.http.GET


interface NetworkService {
    @GET("?action=findAll")
    fun getWisata(): Call<ResultWisata>
}