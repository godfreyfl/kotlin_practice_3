package com.example.kotlinapp23.ViewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.kotlinapp23.utility.DataRepository

class Frag3ViewModel (private val state: SavedStateHandle) : ViewModel() {
    private val dataRepository = DataRepository(String, null)
    var data = dataRepository.getData()
}