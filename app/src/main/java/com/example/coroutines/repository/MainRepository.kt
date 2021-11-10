package com.example.coroutines.repository

import com.example.coroutines.retrofit.RetrofitInterface

class MainRepository(private val retrofitService: RetrofitInterface) {

    suspend fun getAllData() = retrofitService.getAllData()

}