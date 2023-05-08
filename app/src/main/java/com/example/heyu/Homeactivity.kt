package com.example.heyu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.heyu.fragments.HomeFragment

class Homeactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeactivity)
        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            val intent1 = Intent(this, Quotes::class.java)
            startActivity(intent1)
        }
        val btn3 = findViewById<Button>(R.id.btn3)
        btn3.setOnClickListener {
            val intent2 = Intent(this, jokes::class.java)
            startActivity(intent2)
        }
        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {
            val intent3 = Intent(this, HomeFragment::class.java)
            startActivity(intent3)
        }


    }
}