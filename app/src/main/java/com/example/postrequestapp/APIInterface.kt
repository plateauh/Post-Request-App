package com.example.postrequestapp

import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

    @POST("/test/")
    fun addUser(@Body data: UserItem): Call<UserItem?>?

    @GET("/test/")
    fun getUsers(): Call<Users?>?

    @PUT("/test/{id}")
    fun updateUser(@Path("id") id: Int, @Body userData: UserItem): Call<UserItem>

    @PUT("/test/{id}")
    fun deleteUser(@Path("id") id: Int): Call<Void>

}