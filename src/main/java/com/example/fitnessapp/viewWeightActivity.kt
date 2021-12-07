package com.example.fitnessapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.example.fitnessapp.adapters.getWeightsAdapter
import com.example.fitnessapp.services.DataService
import com.example.fitnessapp.services.helper

class viewWeightActivity : AppCompatActivity() {

    lateinit var adapter : getWeightsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_weight)

        // Passing data to the list view
        adapter = getWeightsAdapter(this, DataService.weights)
        val weightlistView = findViewById<ListView>(R.id.weightListView)

        weightlistView.adapter = adapter

        // Managing Dialog view
        val addWeight = findViewById<Button>(R.id.add_weight_btn_id)
        addWeight.setOnClickListener(){

            var dialog = CustomDialogFragment()
            dialog.show(supportFragmentManager, "myDialog")

        }
    }

}