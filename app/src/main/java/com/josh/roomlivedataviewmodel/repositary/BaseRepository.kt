package com.urdhvam.repositories

import com.urdhvam.network.Resource
import com.josh.roomlivedataviewmodel.util.NetworkUtilities
import com.urdhvam.appClass.GlobalData
import retrofit2.Response


open class BaseRepository {

    private val someThingWentWrong: String = "{ \"message\" : \"Something went Wrong\"}"
    private val unAuthorizedUser: String = "{ \"message\" : \"unauthorized\"}"
    private val internalServerError: String = "{ \"message\" : \"Internal server error\"}"
    private val networkError: String = "{ \"message\" : \"Please check your internet connection.\"}"

    // Base Function
// To handle all Api response
    protected fun handleResponse(
        response: Response<Any>?,
        exception: Exception?
    ): Resource<Any> {
        return if (response != null) {
            when {
                response.isSuccessful -> {
                    Resource.success(response.body())
                }
                response.code() == 401 -> {
                    Resource.error(Exception(unAuthorizedUser))
                }
                response.code() == 500 -> {
                    Resource.error(Exception(internalServerError))
                }
                response.code() == 404 -> {
                    Resource.error(Exception(someThingWentWrong))
                }
                else -> {
                    val errorJson =
                        response.errorBody()?.string() ?: someThingWentWrong
                    Resource.error(Exception(errorJson))
                }
            }
        } else {
            return if (!NetworkUtilities.isInternet(GlobalData.mAppContext)) {
                Resource.error(Exception(networkError))
            } else {
                Resource.error(Exception(someThingWentWrong))
            }
        }
    }
}