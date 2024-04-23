package com.example.navgraphbottomview.bottombar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.FrameLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment

import com.example.navgraphbottomview.R


class ShoppingFragment : Fragment() {
    private var isPanelShown = false
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var unifiedDrawer: FrameLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_shopping, container, false)
        drawerLayout = view.findViewById(R.id.drawer_layout)
        unifiedDrawer = view.findViewById(R.id.unified_drawer)

        view.findViewById<Button>(R.id.btn_open_first).setOnClickListener {
            switchDrawerContent(1)
            toggleDrawer()
        }

        view.findViewById<Button>(R.id.btn_open_second).setOnClickListener {
            switchDrawerContent(2)
            toggleDrawer()
        }
        val top_panel = view.findViewById<FrameLayout>(R.id.top_panel)
        val btn_toggle_panel = view.findViewById<Button>(R.id.btn_toggle_panel)
        btn_toggle_panel.setOnClickListener {
            if (isPanelShown) {
                // Slide up and hide the panel
                val slideUp = AnimationUtils.loadAnimation(requireActivity(), R.anim.slide_up)
                top_panel.startAnimation(slideUp)
                top_panel.visibility = View.GONE
            } else {
                // Slide down and show the panel
                val slideDown = AnimationUtils.loadAnimation(requireActivity(), R.anim.slide_down)
                top_panel.startAnimation(slideDown)
                top_panel.visibility = View.VISIBLE
            }
            isPanelShown = !isPanelShown
        }

        return view
    }

    private fun switchDrawerContent(drawerType: Int) {
        // Clear existing views or hide them, then load or show the appropriate content
        unifiedDrawer.removeAllViews()
        val inflater = LayoutInflater.from(context)
        when (drawerType) {
            1 -> inflater.inflate(R.layout.first_drawer_content, unifiedDrawer, true)
            2 -> inflater.inflate(R.layout.second_drawer_content, unifiedDrawer, true)
        }
    }

    private fun toggleDrawer() {
        if (drawerLayout.isDrawerOpen(unifiedDrawer)) {
            drawerLayout.closeDrawer(unifiedDrawer)
        } else {
            drawerLayout.openDrawer(unifiedDrawer)
        }
    }
}