package com.ekremkocak.nfcreader.ui.nfcread

import android.app.PendingIntent
import android.content.Intent
import android.nfc.NfcAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ekremkocak.nfcreader.databinding.FragmentNfcReaderBinding


class FragmentNfcRead: Fragment() {
    private var nfcAdapter: NfcAdapter? = null
    lateinit var fragmentNfcReaderBinding: FragmentNfcReaderBinding
    override fun toString(): String {
        return super.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNfcAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentNfcReaderBinding = FragmentNfcReaderBinding.inflate(layoutInflater,container,false)
        return fragmentNfcReaderBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initNfcAdapter()
    }


    override fun onResume() {
        super.onResume()
        enableNfcForegroundDispatch()
    }
    override fun onPause() {
        disableNfcForegroundDispatch()
        super.onPause()
    }

    private fun enableNfcForegroundDispatch() {
        try {
            val intent = Intent(activity, javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            val nfcPendingIntent = PendingIntent.getActivity(activity, 0, intent,
                PendingIntent.FLAG_MUTABLE)
            nfcAdapter?.enableForegroundDispatch(activity, nfcPendingIntent, null, null)
        } catch (ex: IllegalStateException) {
            //Log.e(getTag(), "Error enabling NFC foreground dispatch", ex)
        }
    }

    private fun disableNfcForegroundDispatch() {
        try {
            nfcAdapter?.disableForegroundDispatch(activity)
        } catch (ex: IllegalStateException) {
            //Log.e(getTag(), "Error disabling NFC foreground dispatch", ex)
        }
    }

    private fun initNfcAdapter() {
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(activity)?.let { it }


        nfcAdapter!!.enableReaderMode(activity, { tag ->
            val uid = tag.id
            val tagId = tag.id

            val tagInfo = StringBuilder()
            for (aTagId in tagId) {
                tagInfo.append(Integer.toHexString(aTagId.toInt() and 0xFF)).append(" ")
            }
            tagInfo.append("\n")
            println("okundu $tagInfo"  )
        }, NfcAdapter.FLAG_READER_NFC_A or NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK, null)
    }






}