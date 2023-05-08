package com.example.heyu

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({val intent = Intent(this@MainActivity, Login_main::class.java)
            startActivity(intent)
            finish()
        },3000)
        }
    }