package com.mentalstack.testmvvm.data

import android.util.Log
import java.util.concurrent.TimeUnit

class CharService {

    private var thread: Thread? = null

    fun startGenerateData(action: (String) -> Unit) {
        if (thread?.isAlive != true) {
            thread = Thread {
                var counter = 'A'
                while (true) {
                    try {
                        action(counter.toString())
                        Log.d("Log", counter.toString())
                        TimeUnit.MILLISECONDS.sleep(50)

                        if (counter == 'z') counter = 'A'
                        else counter++

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