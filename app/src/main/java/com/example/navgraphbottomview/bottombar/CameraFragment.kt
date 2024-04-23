package com.example.navgraphbottomview.bottombar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment

import com.example.navgraphbottomview.R


class CameraFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_camera, container, false)
        val drawerLinearLayout = view.findViewById<DrawerLayout>(R.id.drawer_layout)

        // Create and add 10 EditText views dynamically
        for (i in 1..10) {
            val editText = EditText(requireActivity()).apply {
               LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                hint = "Enter Text $i"
                textSize = 16f
                setPadding(20, 20, 20, 20)
                setBackgroundResource(android.R.color.white)
                id = View.generateViewId()
            }
            drawerLinearLayout.addView(editText)
        }
        return  view
    }

}