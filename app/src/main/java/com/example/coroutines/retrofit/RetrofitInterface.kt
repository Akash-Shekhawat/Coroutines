package com.example.coroutines.retrofit

import com.example.coroutines.model.Model
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RetrofitInterface {

    @GET("posts")
    suspend fun getAllData() : Response<List<Model>>

    companion object {
        var retrofitService: RetrofitInterface? = null
        fun getInstance() : RetrofitInterface {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitInterface::class.java)
            }
            return retrofitService!!
        }

    }
}