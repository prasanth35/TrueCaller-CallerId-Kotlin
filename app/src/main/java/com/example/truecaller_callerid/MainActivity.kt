package com.example.truecaller_callerid

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var receiver: CallService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiver = CallService()
        IntentFilter(Intent.EXTRA_PHONE_NUMBER).also{
            registerReceiver(receiver,it)
        }
    }
}