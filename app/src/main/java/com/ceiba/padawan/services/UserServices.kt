package com.ceiba.padawan.services

import com.ceiba.padawan.store.vo.Post
import com.ceiba.padawan.store.vo.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserServices {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    @GET("posts")
    suspend fun getPosts(@Query("userId") userId: Int): Response<List<Post>>
}
