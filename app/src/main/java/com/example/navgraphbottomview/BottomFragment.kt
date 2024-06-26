package com.example.navgraphbottomview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs


class BottomFragment : Fragment() {

    private val safeArgs: BottomFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvBottom = view.findViewById<TextView>(R.id.tvBottom)
        val myData = safeArgs.myData

        tvBottom.text = "Name: ${myData?.name}, value: ${myData?.value}"

    }

}