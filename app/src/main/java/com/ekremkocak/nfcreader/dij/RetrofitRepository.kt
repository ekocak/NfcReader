package com.ekremkocak.nfcreader.dij


import androidx.lifecycle.MutableLiveData
import com.ekremkocak.nfcreader.model.User
import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class RetrofitRepository @Inject constructor() {


    @Inject
    lateinit var retrofitServiceInstance: RetrofitServiceInstance

    val handler = CoroutineExceptionHandler {context, throwable ->
        println("exception: ${throwable.message}")
    }
    fun login(liveData: MutableLiveData<List<User>>,url: String) {




        val job = CoroutineScope(Dispatchers.IO).launch(handler){

            val response: Response<List<User>> = retrofitServiceInstance.users(url)




            withContext(Dispatchers.Main + handler){
                println("response")
                if (response.isSuccessful) {
                    println("success : ")
                    response.body()?.let { liveData.postValue(response.body()) }
                } else
                    liveData.postValue(null)
            }
        }


    }




}