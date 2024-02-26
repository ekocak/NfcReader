package com.ekremkocak.nfcreader.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ekremkocak.nfcreader.MainActivity
import com.ekremkocak.nfcreader.R
import com.ekremkocak.nfcreader.databinding.UserCellBinding
import com.ekremkocak.nfcreader.model.User
import com.ekremkocak.nfcreader.ui.nfcread.NfcReadActivity
import com.ekremkocak.nfcreader.ui.tflow.TensorFlowFragment
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UsersAdapter   @Inject constructor(@ApplicationContext private var appContext: Context): RecyclerView.Adapter<UserViewHolder>(),UserClickListener {

    var users : List<User>
    lateinit var activity: MainActivity
    init {
        users = mutableListOf()
    }

    fun setActivity(activity : Activity){
        this.activity = activity as MainActivity
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = UserCellBinding.inflate(inflater,parent,false);
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.view.user = users?.get(position)
        holder.view.clickListener = this
    }

    override fun getItemCount(): Int {
        return users.size
    }


    fun setList(users : List<User>){
        this.users = users
        notifyDataSetChanged()
    }


    override fun onUserClicked(user: User) {
        if (user.id.toInt() %2 == 0){
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.container, TensorFlowFragment()).commit()
        }else{
            activity.startActivity(Intent(activity, NfcReadActivity::class.java))
        }

    }



}

class UserViewHolder(var view: UserCellBinding): RecyclerView.ViewHolder(view.root) {






}