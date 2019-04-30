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
import com.example.softballapp.*
import com.example.softballapp.Activities.TeamActivity
import io.objectbox.kotlin.query


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomepageFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomepageFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomepageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var addPlayerFrag:AddPlayerFragment
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    lateinit var act: TeamActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        addPlayerFrag = AddPlayerFragment.newInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_homepage, container, false)
        val addPlayerButton:Button = view.findViewById(R.id.addPlayer)
        val testButton:Button = view.findViewById(R.id.playerNum)
        val result:TextView = view.findViewById(R.id.textView2)
        var teamBox = ObjectBox.boxStore.boxFor(Team::class.java)
        var players:MutableList<String> = ArrayList()
        val team = act.team


        testButton.setOnClickListener {
            val query = teamBox.query {
                order(Team_.teamName)
            }
            val results = query.find()

            result.text = team.players.size.toString()
        }

        addPlayerButton.setOnClickListener {
            CreateFragment(addPlayerFrag)
        }

        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        act = context as TeamActivity
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

    fun CreateFragment(frag:Fragment){
        fragmentManager!!
            .beginTransaction()
            .replace(R.id.contentTeam, frag)
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
         * @return A new instance of fragment HomepageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            HomepageFragment().apply {

            }
    }
}
