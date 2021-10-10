package com.example.postrequestapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIInterface {

    @POST("/test/")
    fun addUser(@Body data: Users): Call<Users>

    @GET("/test/")
    fun getUsers(): Call<Users?>?
}