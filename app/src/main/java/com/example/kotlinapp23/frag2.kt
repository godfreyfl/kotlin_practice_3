package com.example.kotlinapp23

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.VideoView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.kotlinapp23.ViewModels.Frag2ViewModel

class frag2 : Fragment() {

    companion object {
        fun newInstance() = frag2()
    }

    private val viewModel: Frag2ViewModel by viewModels()
    private val mainViewModel: MainViewModel by viewModels(ownerProducer = { requireActivity() })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view: View = inflater.inflate(R.layout.fragment_second, container, false)


        viewModel.data.value?.setData("Nothing happened yet")

        viewModel.data.value?.getData()?.observe(viewLifecycleOwner) { data ->
            var text: TextView = view.findViewById(R.id.TextSecondPage)
            var valuha = data;
            text.setText(valuha)
        }

        var videoView: VideoView = view.findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+ view.context.packageName +"/raw/cat_")

        var button: Button = view.findViewById(R.id.ButtonHeinous)

        button.setOnClickListener {
            videoView.start();
            viewModel.data.value?.setData("Acts commited");
            mainViewModel.data.setData(true);

            var valuha = viewModel.data.value?.getData()?.value
        }


        var button_change: Button = view.findViewById(R.id.button_2);

        button_change.setOnClickListener {
            findNavController().navigate(R.id.action_second_to_third)
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        viewModel.saveState()
        super.onSaveInstanceState(outState)
    }
}