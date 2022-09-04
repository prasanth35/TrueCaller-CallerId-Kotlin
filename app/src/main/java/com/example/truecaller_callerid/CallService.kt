package com.example.truecaller_callerid

import android.content.BroadcastReceiver
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log

class CallService : BroadcastReceiver() {
    private lateinit var simpleFloatingWindow: SimpleFloatingWindow
    override fun onReceive(context: Context?, intent: Intent?) {
        simpleFloatingWindow = context?.let { SimpleFloatingWindow(it) }!!

        Log.d(TAG, "onReceive: BroadCast Receiver")
        var state: String? = intent?.getStringExtra(TelephonyManager.EXTRA_STATE)
        val incomingNumber = intent!!.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
        Log.e("Incoming Number", "Number is ,$incomingNumber")
        Log.d(TAG, "onReceive: State $state")
        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING) || state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            simpleFloatingWindow.show()
        } else {
            Log.d(TAG, "onReceive: ELSE LOOP")
        }
    }
}