package com.example.softballapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val db = Database()
        var teamBox = ObjectBox.boxStore.boxFor(Team::class.java)
        val okButton:Button = findViewById(R.id.OK)
        val teamNameText:EditText = findViewById(R.id.TeamNameText)
        val managerNameText:EditText = findViewById(R.id.editText8)
        val locationText:EditText = findViewById(R.id.editText7)


        okButton.setOnClickListener {
            var team = Team(teamNameText.toString(), managerNameText.toString(), locationText.toString())
            teamBox.put(team)
            val intent = Intent(this, MainActivity::class.java)
            startActivityForResult(intent, 42)
        }
    }
}
