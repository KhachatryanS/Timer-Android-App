package com.example.timer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timerTextView = findViewById<TextView>(R.id.timer)
        var isNotClicked = true
        val mainHandler = Handler(Looper.getMainLooper())
        var runnable: Runnable = object : Runnable  {//create runnable object
            override fun run() {
                timerTextView.text = timer.getTime()
                timer.add()
                mainHandler.postDelayed(this, 1000) // set delay
            }
        }

        findViewById<Button>(R.id.nextPage).setOnClickListener {
            mainHandler.removeCallbacks(runnable)//stop handler
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("hour", timer.hour)
            intent.putExtra("min", timer.minute)
            intent.putExtra("sec", timer.second)
            startActivity(intent)
        }
        findViewById<Button>(R.id.stop).setOnClickListener {
            if(isNotClicked) {
                mainHandler.post(runnable)//start runnable
                isNotClicked = false
            }
        }


    }
}