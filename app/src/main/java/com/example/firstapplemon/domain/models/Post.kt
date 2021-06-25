package com.example.firstapplemon.domain.models

import java.io.Serializable

data class Post(val id: Int, var userId: Int, var title: String, var body: String): Serializable