 package com.example.softballapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import io.objectbox.kotlin.query

 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var teamBox = ObjectBox.boxStore.boxFor(Team::class.java)
        val signupButton:Button = findViewById(R.id.signup)
        val signinButton:Button = findViewById(R.id.signin)
        val showTeamsDebug:Button = findViewById(R.id.showTeams)
        val teamsDisplay:EditText = findViewById(R.id.TeamsText)

        signupButton.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivityForResult(intent, 42)
        }

        signinButton.setOnClickListener {
            val intent = Intent(this, SigninActivity::class.java)
            startActivityForResult(intent, 42)
        }

        showTeamsDebug.setOnClickListener {
            val query = teamBox.query() {
                order(Team_.teamName)
            }
            val results = query.find()
            teamsDisplay.setText(results.count().toString())
        }


    }
 }

