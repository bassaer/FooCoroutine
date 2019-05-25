package com.github.bassaer.foocoroutine

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_view)
        println("thread1 name = ${Thread.currentThread().name}") // thread1 name = main
        Log.d(javaClass.simpleName, "before GlobalScope")
        GlobalScope.launch(Dispatchers.Unconfined) {
            Log.d(javaClass.simpleName, "running GlobalScope")
            textView.text = "Foo!!!!!!!!!"
            println("thread2 name = ${Thread.currentThread().name}") // thread2 name = main
            Toast.makeText(applicationContext, "foo!!!!!!!", Toast.LENGTH_SHORT).show()
        }
        /*
        GlobalScope.launch(Dispatchers.Main) {
            // will crash
        }
        */
        GlobalScope.launch {
            println("thread3 name = ${Thread.currentThread().name}") // thread3 name = DefaultDispatcher-worker-1
        }
        Log.d(javaClass.simpleName, "after GlobalScope")
    }

}
