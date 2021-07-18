package com.josh.roomlivedataviewmodel

/**
 * Created by krishna.
 */
object APIError {

    var statusCode: Int = 0
    var message: String? = null

    fun getErrorCodeMessage(errorCode: Int): String {
        when (errorCode) {
            0 -> return ""
        }
        return "Something went wrong"
    }
}