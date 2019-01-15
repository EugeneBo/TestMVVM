package com.mentalstack.testmvvm.data

import android.util.Log
import java.util.concurrent.TimeUnit

class CounterService {

    private var thread: Thread? = null

    fun startGenerateData(action: (String) -> Unit) {
        if (thread?.isAlive != true) {
            thread = Thread {
                var counter = 0
                while (true) {
                    try {
                        action(counter.toString())
                        Log.d("Log", counter.toString())
                        TimeUnit.MILLISECONDS.sleep(50)
                        counter++
                    } catch (e: InterruptedException) {
                        val string = "$counter \n ${Thread.currentThread().name} interrupted! "
                        action(string)
                        Log.d("Log", string)
                        break
                    }
                }
            }
            thread?.start()

        }
    }

    fun stopGenerateData() {
        thread?.interrupt()
    }

}