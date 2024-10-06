package com.example.kotlinapp23

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.kotlinapp23.ViewModels.Frag3ViewModel

class frag3 : Fragment() {

    companion object {
        fun newInstance() = frag3()
    }

    private val viewModel: Frag3ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view: View = inflater.inflate(R.layout.fragment_third, container, false)

        viewModel.data.observe(viewLifecycleOwner, Observer { data ->

        })

        var button_change: Button = view.findViewById(R.id.button_3);

        button_change.setOnClickListener {
            findNavController().navigate(R.id.action_third_to_first)
        }

        return view
    }
}