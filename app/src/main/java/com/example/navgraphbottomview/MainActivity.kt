package com.example.navgraphbottomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editTextValue = findViewById<EditText>(R.id.editTextValue)
        val imageViewUnit = findViewById<ImageView>(R.id.imageViewUnit)

        imageViewUnit.setOnClickListener { view ->
            showPopupMenu(view, editTextValue)
        }
    }

/*    private fun showPopupMenu(view: View, editText: EditText) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menu.add("knots")
        popupMenu.menu.add("mph")
        popupMenu.setOnMenuItemClickListener { item ->
            // Ensure the unit value is always at the end by splitting and reconstructing the string
            val parts = editText.text.split(" ") // Assumes space as delimiter between number and unit
            val numberPart = if (parts.isNotEmpty()) parts[0] else ""
            editText.setText("$numberPart ${item.title}")
            true
        }

        // Optional: Apply a custom background to the PopupMenu
        popupMenu.setOnDismissListener {
            // To change the background of the popup menu we need access to its internal list view,
            // which is not directly accessible. As a workaround, we may need to apply styles globally or use reflection.
        }

        popupMenu.show()
    }*/

    private fun showPopupMenu(view: View, editText: EditText) {
        // Wrap the context with the custom style
        val contextWrapper = ContextThemeWrapper(this, R.style.CustomPopupMenu)
        val popupMenu = PopupMenu(contextWrapper, view)
        popupMenu.menu.add("knots")
        popupMenu.menu.add("mph")
        popupMenu.setOnMenuItemClickListener { item ->
            val currentText = editText.text.toString().split(" ")[0] // Keep existing number and replace unit
            editText.setText("$currentText ${item.title}")
            true
        }
        popupMenu.show()
    }

    /*private fun showPopupMenu(view: View, editText: EditText) {
        // Apply the custom style to the PopupMenu
        val popupMenu = PopupMenu(this, view, 0, 0, 0, R.style.CustomPopupMenu)
        popupMenu.menu.add("knots")
        popupMenu.menu.add("mph")
        popupMenu.setOnMenuItemClickListener { item ->
            val currentText = editText.text.toString().split(" ")[0] // Keep existing number and replace unit
            editText.setText("$currentText ${item.title}")
            true
        }
        popupMenu.show()
    }*/

}