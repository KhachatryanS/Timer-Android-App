package com.example.timer
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        val stopButton = findViewById<Button>(R.id.stop)
        val timerTextView = findViewById<TextView>(R.id.timer)

        val timer = Timer(intent.getIntExtra("hour", 0), intent.getIntExtra("min", 0), intent.getIntExtra("sec", 0))

        val mainHandler = Handler(Looper.getMainLooper())
        val runnable: Runnable = object : Runnable {
            override fun run() {
                timerTextView.text = timer.getTime()
                timer.add()
                mainHandler.postDelayed(this, 1000)
            }
        }

        mainHandler.post(runnable)

        stopButton.setOnClickListener {
            mainHandler.removeCallbacks(runnable)
        }

    }
}