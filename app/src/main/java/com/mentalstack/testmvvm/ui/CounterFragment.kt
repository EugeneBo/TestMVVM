package com.mentalstack.testmvvm.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mentalstack.testmvvm.R
import com.mentalstack.testmvvm.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding: FragmentCounterBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_counter,
                container, false
            )

        val counterViewModel =
            ViewModelProviders.of(this).get(CounterViewModel::class.java)

        binding.apply {
            setLifecycleOwner(this@CounterFragment)
            viewModel = counterViewModel
        }

        counterViewModel.data.observe(this, Observer<String> {
            Toast.makeText(activity, it.toString(), Toast.LENGTH_SHORT).show()
        })

        return binding.root
    }
}