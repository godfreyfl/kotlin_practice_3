package com.example.kotlinapp23

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.kotlinapp23.ViewModels.Frag1ViewModel

class frag1 : Fragment() {

    companion object {
        fun newInstance() = frag1()
    }

    private val viewModel: Frag1ViewModel by viewModels()
    private val mainViewModel: MainViewModel by viewModels(ownerProducer = { requireActivity() })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)
        //viewModel = ViewModelProvider(this).get(Frag1ViewModel::class.java)

        if(mainViewModel.data.getData().value?.equals(true) == true){
            var text: TextView = view.findViewById(R.id.textView2)
            text.setText("This is First Fragment with another kitty");
            var image: ImageView = view.findViewById(R.id.imageView)
            image.setImageResource(R.drawable.another_kitty);
        } else {
            var image: ImageView = view.findViewById(R.id.imageView)
            image.setImageResource(R.drawable.kitty);
        }

        viewModel.data.observe(viewLifecycleOwner, Observer { data ->
            var text: TextView = view.findViewById(R.id.textView2)
        })

        var button_change: Button = view.findViewById(R.id.button_1);

        button_change.setOnClickListener {
            findNavController().navigate(R.id.action_first_to_second)
        }

        return view
    }
}