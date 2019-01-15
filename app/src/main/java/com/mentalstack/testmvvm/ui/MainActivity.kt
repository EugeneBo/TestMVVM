package com.mentalstack.testmvvm.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.mentalstack.testmvvm.R
import com.mentalstack.testmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.apply {
            setLifecycleOwner(this@MainActivity)
            viewModel = mainViewModel
        }

        mainViewModel.data.observe(this, Observer<String> {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        })

    }

}
