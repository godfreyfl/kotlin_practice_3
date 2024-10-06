package com.example.kotlinapp23

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinapp23.utility.DataRepository

class MainViewModel: ViewModel() {
    private val dataRepository = DataRepository(Boolean, false)
    var data = dataRepository;
}