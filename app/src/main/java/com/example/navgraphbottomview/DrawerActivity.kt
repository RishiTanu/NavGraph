package com.example.navgraphbottomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout

class DrawerActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var firstDrawer: View
    private lateinit var secondDrawer: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

       /* // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dual_drawers, container, false)

        drawerLayout = view.findViewById(R.id.drawer_layout)
        firstDrawer = view.findViewById(R.id.first_drawer)
        secondDrawer = view.findViewById(R.id.second_drawer)
        val buttonOpenFirst = view.findViewById<Button>(R.id.button_open_first_drawer)
        val buttonOpenSecond = view.findViewById<Button>(R.id.button_open_second_drawer)

        buttonOpenFirst.setOnClickListener {
            if (drawerLayout.isDrawerOpen(secondDrawer)) {
                drawerLayout.closeDrawer(secondDrawer)
            }
            drawerLayout.openDrawer(firstDrawer)
        }

        buttonOpenSecond.setOnClickListener {
            if (drawerLayout.isDrawerOpen(firstDrawer)) {
                drawerLayout.closeDrawer(firstDrawer)
            }
            drawerLayout.openDrawer(secondDrawer)
        }

        return view*/
    }
}