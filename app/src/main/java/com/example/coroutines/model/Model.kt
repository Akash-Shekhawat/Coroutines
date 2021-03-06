package com.example.coroutines.model

import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("id")
    val postID: Int,
    @SerializedName("title")
    val postTitle: String,
    @SerializedName("body")
    val postBody: String
)