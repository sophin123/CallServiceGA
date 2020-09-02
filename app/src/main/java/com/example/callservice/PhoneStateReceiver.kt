package com.example.callservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.widget.Toast

class PhoneStateReceiver: BroadcastReceiver(){
    override fun onReceive(context: Context, intent: Intent) {

        var state = intent.extras?.getString(TelephonyManager.EXTRA_STATE)
        if(state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
            Toast.makeText(context, "End Calls", Toast.LENGTH_SHORT).show()
        }
        else if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
            Toast.makeText(context, "Hold", Toast.LENGTH_LONG).show()
        }
        else if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)){

            Toast.makeText(context, "Ringing", Toast.LENGTH_LONG).show()

            var i = Intent(context, GoogleAssistant::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)


        }

    }

}