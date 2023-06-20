package com.example.projet_validation.Repo

import com.example.projet_validation.DAO.Dao
import com.example.projet_validation.Model.Surah
import com.example.projet_validation.Model.User

class Repo {

    private val dao = Dao()






    suspend fun store(surah: Surah)= dao.store(surah)
    suspend fun getAll()= dao.getAll()
    suspend fun ListFavorite()= dao.ListFavorite()
    suspend fun delete(id:Int)= dao.delete(id)
    suspend fun login(user: User)= dao.login(user)
}