package com.ekremkocak.nfcreader.dij


import com.ekremkocak.nfcreader.model.User
import com.ekremkocak.nfcreader.ui.login.LoginResult
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.*


interface RetrofitServiceInstance {

    @GET
    suspend fun users(@Url url: String?): Response<List<User>>


    @POST
    suspend fun login(@Url url: String?): Response<LoginResult>

}