package com.example.callservice

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


open class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var callbutton: Button
    lateinit var googleAssistant: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        enableGoogleAssistant()

        editText = findViewById(R.id.phoneNumber)
        callbutton = findViewById(R.id.callBtn)

        googleAssistant = findViewById(R.id.googleAssitantBtn)

        callbutton.setOnClickListener{
            var intent = Intent(Intent.ACTION_CALL)
            intent.setData(Uri.parse("tel: " + editText.text.toString()))
            startActivity(intent)
        }
//
//        googleAssitantBtn.setOnClickListener{
//
//            var intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
//            startActivityForResult(intent, REQUEST_CODE)
//        }


        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, Array<String>(1){android.Manifest.permission.READ_PHONE_STATE}, 1)
        }


    }

    fun enableGoogleAssistant(){
        var intent = Intent(Intent.ACTION_VOICE_COMMAND)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

//
//    override fun onPause() {
//        super.onPause()
//        enableGoogleAssistant()
//    }

    companion object{
        const val REQUEST_CODE = 1234
    }

}