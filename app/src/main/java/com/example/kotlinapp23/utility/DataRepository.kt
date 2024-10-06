package com.example.kotlinapp23.utility

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataRepository<T>(t:T, value: T) {
    private val data = MutableLiveData<T>()

    fun getData(): LiveData<T> {
        return data
    }

    fun setData(value: T) {
        data.value = value;
    }
}