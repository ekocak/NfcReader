package com.ekremkocak.nfcreader

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ekremkocak.nfcreader.ui.login.LoginFragment
import com.ekremkocak.nfcreader.ui.nfcread.NfcReadActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .replace(R.id.container, LoginFragment()).commit()


        //startActivity(Intent(this, NfcReadActivity::class.java))

    }




}