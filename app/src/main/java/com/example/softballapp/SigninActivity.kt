package com.example.softballapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import io.objectbox.kotlin.query

class SigninActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        var teamBox = ObjectBox.boxStore.boxFor(Team::class.java)
        var teams:MutableList<String> = ArrayList()

        val spinner: Spinner = findViewById(R.id.spinner)

        val query = teamBox.query() {
            order(Team_.teamName)
        }
        val results = query.find()

        for(team in results)
            teams.add(team.teamName)

        val dataAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item, teams
        )

        spinner.adapter = dataAdapter

    }
}
