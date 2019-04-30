package com.example.softballapp.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.example.softballapp.Activities.TeamActivity
import com.example.softballapp.ObjectBox
import com.example.softballapp.Player

import com.example.softballapp.R
import com.example.softballapp.Team

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AddPlayerFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AddPlayerFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class AddPlayerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    lateinit var act:TeamActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_player, container, false)
        val createPlayerButton: Button = view.findViewById(R.id.savePlayer)
        val firstName:TextView = view.findViewById(R.id.playerFirstName)
        val lastName:TextView = view.findViewById(R.id.lastName)
        val posSpinner:Spinner = view.findViewById(R.id.Position)
        val team = act.team

        createPlayerButton.setOnClickListener {
            val player = Player(0, firstName.text.toString(), lastName.text.toString(), posSpinner.selectedItem.toString())
            team.players.add(player)
            val pId:Long = ObjectBox.boxStore.boxFor(Team::class.java).put(team)
            firstName.clearComposingText()
            lastName.clearComposingText()
            posSpinner.setSelection(0)
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddPlayerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            AddPlayerFragment().apply {

            }
    }
}
