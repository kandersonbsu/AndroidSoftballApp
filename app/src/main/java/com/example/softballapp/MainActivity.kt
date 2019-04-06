package com.example.softballapp

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity;
import android.widget.Button
import android.widget.ImageButton

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),TeamFragment.OnFragmentInteractionListener, MainFragment.OnFragmentInteractionListener, CreateTeamFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var teamFrag:TeamFragment
    lateinit var mainFrag:MainFragment
    lateinit var teamBox:ObjectBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val menuButton:ImageButton = findViewById(R.id.imageButton)
        teamFrag = TeamFragment.newInstance()
        mainFrag = MainFragment.newInstance()
        var teamBox = ObjectBox.boxStore.boxFor(Team::class.java)

        //Default Fragment when app opens
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, mainFrag)
            .addToBackStack(mainFrag.toString())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        menuButton.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.content, teamFrag)
                .addToBackStack(teamFrag.toString())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }



}
