package com.example.data.models

import com.google.gson.annotations.SerializedName

data class  PostData(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String)