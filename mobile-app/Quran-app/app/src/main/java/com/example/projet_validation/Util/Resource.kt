package com.example.projet_validation.Util

data class Resource<out T>(val status: status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = status.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): Resource<T> =
            Resource(status = status.ERROR, data = data, message = message)

        fun <T> loading(data: T?): Resource<T> = Resource(status = status.LOADING, data = data, message = null)
    }
}

