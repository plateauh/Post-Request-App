package com.example.postrequestapp

import com.google.gson.annotations.SerializedName

class Users : ArrayList<UserItem>()

data class UserItem (

    @SerializedName("name")
    val location: String,

    @SerializedName("location")
    val name: String
)