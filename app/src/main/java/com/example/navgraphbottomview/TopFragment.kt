package com.example.navgraphbottomview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs


class TopFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvTop = view.findViewById<TextView>(R.id.tvTop)

        // Retrieve the argument
       /* val args: TopFragmentArgs by navArgs()
        val myArgValue = args.myArg*/

        val args = TopFragmentArgs.fromBundle(requireArguments())
        val myArgValue = args.myArg

       // val myArg = arguments?.getInt("myArg")

        tvTop.text = "From Bundle myArg $myArgValue"
    }
}