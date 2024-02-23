package com.ekremkocak.nfcreader

import android.R.attr.value
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ekremkocak.nfcreader.ui.nfcread.FragmentNfcRead
import com.ekremkocak.nfcreader.ui.nfcread.NfcReadActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(binding.navViewA, navController);

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentNfcRead()).commit()


        startActivity(Intent(this, NfcReadActivity::class.java))

    }




}