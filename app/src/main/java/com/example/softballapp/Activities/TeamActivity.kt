package com.example.softballapp.Activities

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity;
import android.widget.Button
import android.widget.ImageButton
import com.example.softballapp.Fragments.HomepageFragment
import com.example.softballapp.Fragments.TeamFragment
import com.example.softballapp.R

import kotlinx.android.synthetic.main.activity_team.*

class TeamActivity : AppCompatActivity(),
    HomepageFragment.OnFragmentInteractionListener,
    TeamFragment.OnFragmentInteractionListener{
    lateinit var homepageFrag: HomepageFragment
    lateinit var teamFrag: TeamFragment

    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)
        setSupportActionBar(toolbar)

        homepageFrag = HomepageFragment.newInstance()
        teamFrag = TeamFragment.newInstance()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val fragButton: ImageButton = findViewById(R.id.imageButton2)

        fragButton.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.contentTeam, teamFrag)
                .addToBackStack(teamFrag.toString())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
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
