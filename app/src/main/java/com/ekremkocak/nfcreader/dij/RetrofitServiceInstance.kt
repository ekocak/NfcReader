package com.ekremkocak.nfcreader.dij


import com.ekremkocak.nfcreader.model.User
import retrofit2.Response
import retrofit2.http.*


interface RetrofitServiceInstance {

    @GET
    suspend fun users(@Url url: String?): Response<List<User>>



    /*
    @POST
    suspend fun postMethod(@Url url: String?, @Header("Authorization") authKey: String?, @Body body: JsonObject?): Response<JsonObject>
*/
}