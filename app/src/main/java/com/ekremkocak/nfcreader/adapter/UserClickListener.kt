package com.ekremkocak.nfcreader.adapter

import android.view.View
import com.ekremkocak.nfcreader.model.User

interface UserClickListener {
    fun onUserClicked(user : User)

}