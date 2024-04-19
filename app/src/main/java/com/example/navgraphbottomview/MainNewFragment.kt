package com.example.navgraphbottomview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.navgraphbottomview.model.Data


class MainNewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_new, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Top fragment gets argument normal way
        val buttonTop = view.findViewById<Button>(R.id.btn_destA)
        buttonTop?.setOnClickListener {

            // Proper usage of named arguments in Kotlin
            val action = MainNewFragmentDirections.actionMainFragmentToTopFragment(myArg = 123)
            findNavController().navigate(action)

          /*  val action = MainNewFragmentDirections.actionMainFragmentToTopFragment(myArg = 123)
            findNavController().navigate(action)*/

            //val bundle = bundleOf("myArg" to 6)
            // 🔥 Alternative 2
           // findNavController().navigate(R.id.action_mainFragment_to_topFragment, bundle)
        }


        val buttonBottom = view.findViewById<Button>(R.id.btn_destC)
        buttonBottom?.setOnClickListener {
            // 🔥 Alternative 3
//            Navigation.findNavController(view).navigate(R.id.bottom_dest)

            val myDataArg = Data("test", 4)
            // Create Action
            val action =
                MainNewFragmentDirections.actionMainFragmentToBottomFragment(
                    myDataArg
                )
            findNavController().navigate(action)
        }

    }
}