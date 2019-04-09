package com.example.softballapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import io.objectbox.kotlin.query


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TeamLoginFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TeamLoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TeamLoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    //https://stackoverflow.com/questions/45735830/button-inside-a-fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var teamBox = ObjectBox.boxStore.boxFor(Team::class.java)
        var teams:MutableList<String> = ArrayList()
        val view:View = inflater.inflate(R.layout.fragment_team_login, container, false)
        val spinner:Spinner = view.findViewById(R.id.spinner)
        val login:Button = view.findViewById(R.id.loginButton)
        val query = teamBox.query {
            order(Team_.teamName)
        }
        val results = query.find()

        //Populate the spinner
        //https://stackoverflow.com/questions/37766715/context-for-arrayadapter-in-fragment-class
        for(team in results)
            teams.add(team.teamName)
        val dataAdapter = ArrayAdapter<String>(activity, android.R.layout.simple_spinner_dropdown_item, teams)
        spinner.adapter = dataAdapter

        //Login button listener
        login.setOnClickListener {
            val intent = Intent(activity, TeamActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TeamLoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            TeamLoginFragment().apply {

            }
    }
}
