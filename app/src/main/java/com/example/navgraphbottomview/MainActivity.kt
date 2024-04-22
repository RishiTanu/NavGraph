package com.example.navgraphbottomview


import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var overlayLayout: View
    private lateinit var unitsAutoCompleteTextView: AutoCompleteTextView

    private lateinit var groundSpeedAutoCompleteTextView: AutoCompleteTextView
    private lateinit var unitsAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val bottomBar = findViewById<SmoothBottomBar>(R.id.smooth_bar)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        bottomBar.onItemSelected = {
            when (it) {
                0 -> navController.navigate(R.id.shoppingFragment)
                1 -> navController.navigate(R.id.detailFragment)
                2 -> navController.navigate(R.id.settingsFragment)
                3 -> navController.navigate(R.id.cameraFragment)
                // Add more cases as per your menu items
            }
        }

        // Optional: Manage back stack behavior or UI updates when navigating
        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Optionally update UI when navigation destination changes
            when (destination.id) {
                R.id.shoppingFragment -> bottomBar.itemActiveIndex = 0
                R.id.detailFragment -> bottomBar.itemActiveIndex = 1
                R.id.settingsFragment -> bottomBar.itemActiveIndex = 2
                R.id.cameraFragment -> bottomBar.itemActiveIndex = 3
                // Add more cases if necessary
            }
        }*/

        // Setup NavController
        /*val navController = findNavController(R.id.nav_host_fragment)

        // Setup BottomNavigationView
        val bottomNav = findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNav?.setupWithNavController(navController)

        // Handle item reselection: navigate to the selected destination
        bottomNav.setOnItemReselectedListener { menuItem ->
            NavigationUI.onNavDestinationSelected(menuItem, navController)
        }

        // Add a listener to respond to changes in the back stack
        supportFragmentManager.addOnBackStackChangedListener {
            val backStackEntryCount = supportFragmentManager.backStackEntryCount
            val fragments = supportFragmentManager.fragments
            val fragmentCount = fragments.size

            // Display Toast message showing the back stack state
            Toast.makeText(
                this,
                "MainActivity backStackEntryCount: $backStackEntryCount, fragmentCount: $fragmentCount, fragments: $fragments",
                Toast.LENGTH_SHORT
            ).show()
        }*/


        val navController = findNavController(R.id.nav_host_fragment)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setupWithNavController(navController)

        val layout = findViewById<ConstraintLayout>(R.id.container)
        val backgroundView = findViewById<View>(R.id.active_item_background)

        // Animate background on item selection
        navView.setOnItemSelectedListener { item ->
            val view = navView.findViewById<View>(item.itemId)
            animateBackground(view, backgroundView, layout)
            true
        }
    }

    private fun animateBackground(targetView: View, backgroundView: View, layout: ConstraintLayout) {
        val transition = ChangeBounds()
        transition.duration = 300

        TransitionManager.beginDelayedTransition(layout, transition)

        val set = ConstraintSet()
        set.clone(layout)
        set.connect(backgroundView.id, ConstraintSet.START, targetView.id, ConstraintSet.START)
        set.connect(backgroundView.id, ConstraintSet.END, targetView.id, ConstraintSet.END)
        set.applyTo(layout)
    }

        /*val editTextValue = findViewById<EditText>(R.id.editTextValue)
        val imageViewUnit = findViewById<ImageView>(R.id.imageViewUnit)

        imageViewUnit.setOnClickListener { view ->
            showPopupMenu(view, editTextValue)
        }*/
        /*val groundSpeedAutoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.unitsAutoCompleteTextView)
        val units = arrayOf("km/h", "Knots", "Mach")

        // Create an adapter for the units
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, units)
        groundSpeedAutoCompleteTextView.setAdapter(adapter)

        // Handle the dropdown item click
        groundSpeedAutoCompleteTextView.setOnItemClickListener { adapterView, view, position, id ->
            val selectedUnit = adapter.getItem(position) ?: return@setOnItemClickListener
            // Append the selected unit to the current number input
            val currentText = groundSpeedAutoCompleteTextView.text.toString()
            // Use regex to remove existing unit if present
            val numericValue = currentText.replace(Regex("[^\\d.]"), "")
            groundSpeedAutoCompleteTextView.setText("$numericValue $selectedUnit")
            // Move the cursor to the end of the text
            groundSpeedAutoCompleteTextView.setSelection(groundSpeedAutoCompleteTextView.text.length)
        }

        // To make sure user cannot edit the unit part, handle the before text changed event
        groundSpeedAutoCompleteTextView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Prevent user from modifying the unit
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // Implement logic as needed
            }

            override fun afterTextChanged(s: Editable) {
                // Implement logic as needed
            }
        })*/
      //  setupUnitDropdown()

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item)
    }

    /*private fun onUnitSelected(unit: String) {
        // Update your data based on the selected unit
    }*/
    /*private fun setupUnitDropdown() {
        groundSpeedAutoCompleteTextView = findViewById(R.id.groundSpeedAutoCompleteTextView)

        val units = arrayOf("Knots", "Mach", "Km/h")
        unitsAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, units)
        groundSpeedAutoCompleteTextView.apply {
            setAdapter(unitsAdapter)
            setOnItemClickListener { _, _, position, _ ->
                setText(getText().toString().replace(Regex("[A-Za-z]+"), "").trim() + " " + units[position])
                setSelection(0, getText().length - units[position].length - 1) // Keep the focus on the numeric part
            }
            onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    // Show all units when the user focuses on the AutoCompleteTextView
                    showDropDown()
                }
            }
            // This will initiate the dropdown when the end icon is pressed
            (parent.parent as TextInputLayout).setEndIconOnClickListener {
                showDropDown()
            }
        }
    }*/
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

    /*private fun showPopupMenu(view: View, editText: EditText) {
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
    }*/

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