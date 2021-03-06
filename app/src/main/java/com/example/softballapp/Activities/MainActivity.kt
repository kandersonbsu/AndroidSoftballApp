package com.example.softballapp.Activities

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton
import com.example.softballapp.Fragments.CreateTeamFragment
import com.example.softballapp.Fragments.MainFragment
import com.example.softballapp.Fragments.TeamFragment
import com.example.softballapp.Fragments.TeamLoginFragment
import com.example.softballapp.R

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    TeamFragment.OnFragmentInteractionListener,
    MainFragment.OnFragmentInteractionListener,
    CreateTeamFragment.OnFragmentInteractionListener,
    TeamLoginFragment.OnFragmentInteractionListener
{
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var teamFrag: TeamFragment
    lateinit var mainFrag: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



        val menuButton:ImageButton = findViewById(R.id.imageButton)

        teamFrag = TeamFragment.newInstance()
        mainFrag = MainFragment.newInstance()



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
