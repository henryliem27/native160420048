package com.example.numbergame_160420048

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import kotlin.random.Random

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    companion object{
        private var score:Int = 0
        private lateinit var playerName:String
    }
    @SuppressLint("DetachAndAttachSameFragment", "SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnSubmit:View = view.findViewById(R.id.btnSubmit)
        val txtNumber:TextView = view.findViewById(R.id.txtNumber)
        val txtAnswer:TextView = view.findViewById(R.id.txtAnswer)
        arguments?.let{
            playerName = MainFragmentArgs.fromBundle(requireArguments()).toString()
            txtNumber.text= "$playerName's Turn"
        }
        val randomInt = Random.nextInt(100)
        val randomInt1 = Random.nextInt(100)
        txtNumber.text = "${randomInt.toString()} + ${randomInt1.toString()}"

        btnSubmit.setOnClickListener{
            val yourAnswer:Int = Integer.parseInt(txtAnswer.text.toString())
            val hasil:Int = randomInt+randomInt1
            if(hasil != yourAnswer){
                val action = MainFragmentDirections.actionMainFragment(score)
                Navigation.findNavController(it).navigate(action)
            }else{
                score++
                val action1 = MainFragmentDirections.actionMainFragmentSelf(playerName)
                Navigation.findNavController(it).navigate(action1)
            }
        }
    }

}