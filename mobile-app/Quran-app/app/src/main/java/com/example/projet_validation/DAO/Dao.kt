package com.example.projet_validation.DAO

import com.example.projet_validation.DAO.API.ApiServicesInterface
import com.example.projet_validation.Model.Surah
import com.example.projet_validation.Model.Univer
import com.example.projet_validation.Model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Dao {

    companion object{
        // private var url ="http://192.168.2.46:8000/api/"
        private var url ="http://192.168.1.39:8000/api/"
        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val apiService: ApiServicesInterface = getRetrofit().create(ApiServicesInterface::class.java)

    }






    suspend fun store(surah: Surah)= apiService.store(surah)
    suspend fun getAll()= apiService.getAll()
    suspend fun ListFavorite()= apiService.ListFavorite()


    suspend fun delete(id:Int)= apiService.delete(id)
    suspend fun login(user: User)= apiService.login(user)

}