package com.example.fitnessapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.fitnessapp.adapters.getWeightsAdapter
import com.example.fitnessapp.services.DataService

class viewWeightActivity : AppCompatActivity() {

    lateinit var adapter : getWeightsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_weight)

        adapter = getWeightsAdapter(this, DataService.weights)
        val weightlistView = findViewById<ListView>(R.id.weightListView)

        weightlistView.adapter = adapter

    }

}