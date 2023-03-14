package com.example.numbergame_160420048

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation


class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnStart:View = view.findViewById(R.id.btnStart)
        val txtName:TextView = view.findViewById(R.id.txtName)

        btnStart.setOnClickListener{
            val playerName: String = txtName.text.toString()
            val action = IntroFragmentDirections.actionIntroFragment(playerName)
            Navigation.findNavController(it).navigate(action)
        }
    }
}
