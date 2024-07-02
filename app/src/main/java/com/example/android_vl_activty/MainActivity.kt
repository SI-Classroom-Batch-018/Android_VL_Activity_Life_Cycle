package com.example.android_vl_activty

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_vl_activty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var counter = 0
    var counterMinus = 0
    // Schritt 1 ViewBinding
    private lateinit var vb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Schritt 2 ViewBinding
        vb = ActivityMainBinding.inflate(layoutInflater)

        // Schritt 3 ViewBinding
        setContentView(vb.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.i("LIVE_CYCLE", "onCreate")

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("COUNTER")
            counterMinus = savedInstanceState.getInt("COUNTER_MINUS")
            vb.tvCounter.text = counter.toString()
            vb.tvCounterMinus.text = counterMinus.toString()
        }

        vb.btCounter.setOnClickListener {
            counter ++
            counterMinus --
            //findViewById<TextView>(R.id.tv_counter).text = counter.toString()
            vb.tvCounter.text = counter.toString()
            vb.tvCounterMinus.text = counterMinus.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.v("LIVE_CYCLE", "onSaveInstanceState $outState")
        outState.putInt("COUNTER", counter)
        outState.putInt("COUNTER_MINUS", counterMinus)
    }


    override fun onStart() {
        super.onStart()

        Log.v("LIVE_CYCLE", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d("LIVE_CYCLE", "onResume")
    }

    override fun onStop() {
        super.onStop()

        Log.v("LIVE_CYCLE", "onStop")
    }

    override fun onPause() {
        super.onPause()

        Log.i("LIVE_CYCLE", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.wtf("LIVE_CYCLE", "onDestroy")
    }
}