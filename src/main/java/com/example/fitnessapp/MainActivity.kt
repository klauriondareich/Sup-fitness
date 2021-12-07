package com.example.fitnessapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.fitnessapp.Model.Weights
import com.example.fitnessapp.adapters.getWeightsAdapter
import com.example.fitnessapp.services.DataService
import com.example.fitnessapp.services.helper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewWeightBtn = findViewById<Button>(R.id.viewWeightId)
        val trackRunIdBtn = findViewById<Button>(R.id.trackRunId)

        viewWeightBtn.setOnClickListener{
            val viewWeightIntent = Intent(this, viewWeightActivity::class.java)
            startActivity(viewWeightIntent)
        }


        trackRunIdBtn.setOnClickListener{
            val trackUserRunIntent = Intent(this, TrackUserRun::class.java)
            startActivity(trackUserRunIntent)
        }
    }
}