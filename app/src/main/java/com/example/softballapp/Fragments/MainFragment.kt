package com.example.softballapp.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.softballapp.ObjectBox
import com.example.softballapp.R
import com.example.softballapp.Team
import com.example.softballapp.Team_
import io.objectbox.kotlin.query


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MainFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MainFragment : Fragment(),View.OnClickListener {
    lateinit var newTeamFrag: CreateTeamFragment
    lateinit var teamLoginFrag: TeamLoginFragment


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
        newTeamFrag = CreateTeamFragment.newInstance()
        teamLoginFrag = TeamLoginFragment.newInstance()


    }
    //https://stackoverflow.com/questions/7508044/android-fragment-no-view-found-for-id
    //https://stackoverflow.com/questions/47014469/only-safe-or-non-null-assserted-calls-are-allowed-on-a-nullable-receiver-type-of
    
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.createTeamButton -> {
                CreateFragment(newTeamFrag)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_main, container, false)
        val cb:Button = view.findViewById(R.id.createTeamButton)
        val loginButton:Button = view.findViewById(R.id.loginButton)
        val showTeams:Button = view.findViewById(R.id.showNumTeams)
        val numTeams: TextView = view.findViewById(R.id.numTeamsText)
        var teamBox = ObjectBox.boxStore.boxFor(Team::class.java)
        cb.setOnClickListener(this)
        showTeams.setOnClickListener {
            val query = teamBox.query {
                order(Team_.teamName)
            }
            val results = query.find()
            numTeams.text = results.count().toString()
        }
        loginButton.setOnClickListener {
            CreateFragment(teamLoginFrag)
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

    fun CreateFragment(frag:Fragment): Unit{
        fragmentManager!!
            .beginTransaction()
            .replace(R.id.content, frag)
            .addToBackStack(frag.toString())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {

            }
    }
}
