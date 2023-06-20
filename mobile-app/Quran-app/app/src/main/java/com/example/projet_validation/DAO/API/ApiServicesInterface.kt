package com.example.projet_validation.DAO.API

import com.example.projet_validation.Model.Surah
import com.example.projet_validation.Model.Univer
import com.example.projet_validation.Model.User
import retrofit2.http.*

interface ApiServicesInterface {



    @GET("getItem/{params}")
    suspend fun getItem(@Path("params") params:String): List<Univer>





    @POST("store")
    suspend fun store(@Body surah: Surah):Int

    @GET("getAll")

    suspend fun getAll():List<Surah>

 @GET("ListFavorite")

    suspend fun ListFavorite():List<Surah>

    @GET("delete/{id}")
    suspend fun delete(@Path("id") id:Int):Int

    @POST("login")
    suspend fun login(@Body user:User):User

}