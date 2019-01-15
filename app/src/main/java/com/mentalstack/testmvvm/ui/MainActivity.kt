package com.mentalstack.testmvvm.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mentalstack.testmvvm.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        var fragment = fm.findFragmentById(R.id.fragment_container)

        if (fragment == null) {
            fragment = CounterFragment()
            fm.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }

}
