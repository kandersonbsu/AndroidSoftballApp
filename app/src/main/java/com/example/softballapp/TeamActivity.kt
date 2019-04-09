package com.example.softballapp

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_team.*

class TeamActivity : AppCompatActivity(),
    HomepageFragment.OnFragmentInteractionListener {
    lateinit var homepageFrag:HomepageFragment
    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)
        setSupportActionBar(toolbar)
        homepageFrag = HomepageFragment.newInstance()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        //Default fragment when created.
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.contentTeam, homepageFrag)
            .addToBackStack(homepageFrag.toString())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }



}
