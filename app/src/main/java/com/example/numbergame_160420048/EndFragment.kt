package com.example.numbergame_160420048

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation

class EndFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_end, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtTurn: TextView = view.findViewById<TextView>(R.id.txtTurn)
        val btnBack = view.findViewById<View>(R.id.btnBack)
        arguments?.let{
            val score = EndFragmentArgs.fromBundle(requireArguments()).score
            txtTurn.text = "Your Score is $score"
        }
        btnBack.setOnClickListener{
            val action = EndFragmentDirections.actionEndFragmentToIntroFragment2()
            Navigation.findNavController(it).navigate(action)
        }
    }
}