package com.example.recycleviewapp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //val planetsList = arrayListOf<String>("Mars", "Venus", "Earth")
    val variants = "1234567890abcdef";


    val colorsList = mutableListOf(android.graphics.Color.argb(255, (0..256).random(), (0..256).random(), (0..256).random()));

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // пример использования RecyclerView с собственным адаптером
        for (i in 0..10){
            colorsList.add(colorsList[0]+16*i)
        }
        val rv = findViewById<RecyclerView>(R.id.rview)
        val colorAdapter = ColorAdapter(LayoutInflater.from(this))
        // добавляем данные в список для отображения
        colorAdapter.submitList(colorsList)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = colorAdapter
    }
}