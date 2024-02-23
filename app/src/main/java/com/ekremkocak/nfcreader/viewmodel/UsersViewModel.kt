package com.ekremkocak.nfcreader.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ekremkocak.nfcreader.dij.RetrofitRepository
import com.ekremkocak.nfcreader.model.User
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsersViewModel  @Inject constructor(private val repository: RetrofitRepository) : ViewModel() {
    var liveData : MutableLiveData<List<User>>
    init {
        liveData = MutableLiveData()
    }
    fun getData(){
        repository.login(liveData,"users")
    }
}