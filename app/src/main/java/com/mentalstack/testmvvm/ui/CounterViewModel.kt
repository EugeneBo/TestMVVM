package com.mentalstack.testmvvm.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.Bindable
import com.mentalstack.testmvvm.data.CharService
import com.mentalstack.testmvvm.data.CounterService

class CounterViewModel : ViewModel() {

    private val counterService = CharService()

    @Bindable
    val data = MutableLiveData<String>()

    fun onStartClicked() {
        counterService.startGenerateData {
            data.postValue(it)
        }
    }

    fun onStopClicked() {
        counterService.stopGenerateData()
    }


}