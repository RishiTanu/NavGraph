package com.example.navgraphbottomview.bottombar

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.example.navgraphbottomview.R
import com.example.navgraphbottomview.SharedViewModel


class SettingsFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel
    private lateinit var frameLayout: FrameLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view =  inflater.inflate(R.layout.fragment_settings, container, false)
        frameLayout = view.findViewById<FrameLayout>(R.id.frameLayoutContainer)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        viewModel.screenshot.observe(viewLifecycleOwner) { bitmap ->
            displayBitmap(bitmap)
        }
    }

    private fun displayBitmap(bitmap: Bitmap) {
        frameLayout.apply {
            layoutParams.height = 500.dpToPx(requireContext())
            requestLayout()
            setBackgroundDrawable(BitmapDrawable(resources, bitmap))
        }
    }

    private fun Int.dpToPx(context: Context): Int = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics
    ).toInt()
}