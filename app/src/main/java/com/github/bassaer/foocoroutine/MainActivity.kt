package com.github.bassaer.foocoroutine

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_view)
        Log.d(javaClass.simpleName, "before GlobalScope")
        GlobalScope.launch {
            Log.d(javaClass.simpleName, "running GlobalScope")
            textView.text = "Foo!!!!!!!!!"
        }
        Log.d(javaClass.simpleName, "after GlobalScope")
    }

}
