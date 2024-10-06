package com.example.kotlinapp23.ViewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.kotlinapp23.utility.DataRepository

class Frag2ViewModel(private val state: SavedStateHandle) : ViewModel() {
    var data = state.getLiveData<DataRepository<String>>("data", DataRepository(String(), "nothing happened yet"));

    fun saveState() {
        state["data"] = data;
    }
}