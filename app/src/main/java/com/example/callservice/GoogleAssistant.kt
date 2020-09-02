package com.example.callservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GoogleAssistant : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trail)

        googleAssistantEnabled()

    }

    fun googleAssistantEnabled(){
        var intent = Intent(Intent.ACTION_VOICE_COMMAND)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}