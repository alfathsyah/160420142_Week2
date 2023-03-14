package com.example.adv160420142week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import kotlin.random.Random

class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val playerName =
                GameFragmentArgs.fromBundle(requireArguments()).playerName
            val txtTurn = view.findViewById<TextView>(R.id.txtTurn)
            txtTurn.text = "$playerName's Turn"
        }

        val randNum1 = Random.nextInt(0,150)

        val randNum2 = Random.nextInt(0,150)

        val txtNum1 = view.findViewById<TextView>(R.id.txtNum1)
        txtNum1.text = randNum1.toString()

        val txtNum2 = view.findViewById<TextView>(R.id.txtNum2)
        txtNum2.text = randNum1.toString()

        var total = randNum1 + randNum2

        val txtAnswer = view.findViewById<TextView>(R.id.txtAnswer)
        var answer = txtAnswer.text

        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            if (answer.toString() == total.toString()){
                Global.score += 10
                val action = GameFragmentDirections.actionAgain(Global.playerName)
                Navigation.findNavController(it).navigate(action)
            }
            else{
                val action = GameFragmentDirections.actionResultFragment(Global.score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

}