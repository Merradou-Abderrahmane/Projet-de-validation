package com.example.projet_validation.Ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.projet_validation.Model.Surah
import com.example.projet_validation.Model.Univer
import com.example.projet_validation.Model.User
import com.example.projet_validation.Repo.Repo
import com.example.projet_validation.Util.Resource
import kotlinx.coroutines.Dispatchers

class ViewModel : ViewModel() {

    private val repo = Repo()













    fun  store(surah: Surah)= liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.store(surah)))
        }
        catch (exception:Exception){
            emit(Resource.error(data = null, message = exception.message?:"Error"))
        }
    }

    fun  getAll()= liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.getAll()))
        }
        catch (exception:Exception){
            emit(Resource.error(data = null, message = exception.message?:"Error"))
        }
    }
    fun  ListFavorite()= liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.ListFavorite()))
        }
        catch (exception:Exception){
            emit(Resource.error(data = null, message = exception.message?:"Error"))
        }
    }

    fun  delete(id :Int)= liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.delete(id)))
        }
        catch (exception:Exception){
            emit(Resource.error(data = null, message = exception.message?:"Error"))
        }
    }

    fun  login(user: User)= liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.login(user)))
        }
        catch (exception:Exception){
            emit(Resource.error(data = null, message = exception.message?:"Error"))
        }
    }



}