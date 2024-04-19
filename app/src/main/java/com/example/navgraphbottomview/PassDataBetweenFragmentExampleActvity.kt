package com.example.navgraphbottomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class PassDataBetweenFragmentExampleActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass_data_between_fragment_example_actvity)

        supportFragmentManager.addOnBackStackChangedListener {
            val backStackEntryCount = supportFragmentManager.backStackEntryCount
            val fragments = supportFragmentManager.fragments


            Toast.makeText(
                this,
                "MainActivity() backStackEntryCount: $backStackEntryCount, fragments size: ${fragments.size}",
                Toast.LENGTH_SHORT
            ).show()

        }
    }
}