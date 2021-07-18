package com.urdhvam.network

class Resource<T> private constructor(
    val status: Status,
    val data: T?,
    val exception: Exception?
) {
    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(exception: Exception?): Resource<T> {
            return Resource(
                Status.ERROR,
                null,
                exception
            )
        }

        public fun <T> loading(data: T?): Resource<T> {
            return Resource(
                Status.LOADING,
                data,
                null
            )
        }
    }
}