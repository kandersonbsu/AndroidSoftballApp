 package com.example.softballapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signupButton:Button = findViewById(R.id.signup)
        val signinButton:Button = findViewById(R.id.signin)

        signupButton.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivityForResult(intent, 42)
        }

        signinButton.setOnClickListener {
            val intent = Intent(this, SigninActivity::class.java)
            startActivityForResult(intent, 42)
        }


    }
 }

