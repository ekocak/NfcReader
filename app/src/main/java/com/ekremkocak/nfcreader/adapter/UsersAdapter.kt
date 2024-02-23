package com.ekremkocak.nfcreader.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ekremkocak.nfcreader.databinding.UserCellBinding
import com.ekremkocak.nfcreader.model.User
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UsersAdapter   @Inject constructor(@ApplicationContext private var appContext: Context): RecyclerView.Adapter<UserViewHolder>() {

    var users : List<User>
    init {
        users = mutableListOf()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = UserCellBinding.inflate(inflater,parent,false);
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        println(    "user id ${users?.get(position)?.id}")


        holder.view.user = users?.get(position)
    }

    override fun getItemCount(): Int {
        return users.size
    }


    fun setList(users : List<User>){
        this.users = users
        users.forEach { println("id : ${it.id}") }
        this.notifyDataSetChanged()
    }

}

class UserViewHolder(var view: UserCellBinding): RecyclerView.ViewHolder(view.root) {






}