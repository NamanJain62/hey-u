package com.example.heyu

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel2(val context: Context): ViewModel() {
    private var jokeList: Array<Quote> = emptyArray()
    private var index = 0

    init {
        jokeList = loadQuoteFromAssets()
    }

    private fun loadQuoteFromAssets(): Array<Quote> {
        val inputStream = context.assets.open("jokes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<Quote>::class.java)
    }

    fun getQuote() = jokeList[index]

    fun nextQuote() = jokeList[++index % jokeList.size]

    fun previousQuote() = jokeList[(--index + jokeList.size) % jokeList.size]
}
