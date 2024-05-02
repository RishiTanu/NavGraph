package com.example.navgraphbottomview.bottombar

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import com.example.navgraphbottomview.R
import com.example.navgraphbottomview.SharedViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class DetailFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_detail, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        val button = view.findViewById<Button>(R.id.btnAddData)
        val fragment_layout = view.findViewById<ConstraintLayout>(R.id.fragment_layout)
        button.setOnClickListener {
            val screenshot = takeScreenshot(fragment_layout)
            viewModel.screenshot.value = screenshot
          //  findNavController().navigate(R.id.action_detailFragment_to_settingFragment)
            requireActivity().findViewById<BottomNavigationView>(R.id.nav_view).selectedItemId = R.id.settingsFragment
        }

        return view
    }

    fun takeScreenshot(view: View): Bitmap {
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    }
}