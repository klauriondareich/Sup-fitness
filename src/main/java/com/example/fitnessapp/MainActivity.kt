package com.example.fitnessapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewWeightBtn = findViewById<Button>(R.id.viewWeightId)
        val trackRunIdBtn = findViewById<Button>(R.id.trackRunId)
        val curveBtn = findViewById<Button>(R.id.weightCurveId)

        viewWeightBtn.setOnClickListener{
            val viewWeightIntent = Intent(this, viewWeightActivity::class.java)
            startActivity(viewWeightIntent)
        }


        trackRunIdBtn.setOnClickListener{
            val trackUserRunIntent = Intent(this, TrackUserRun::class.java)
            startActivity(trackUserRunIntent)
        }

        curveBtn.setOnClickListener{
            val curveIntent = Intent(this, WeightsCurve::class.java)
            startActivity(curveIntent)
        }
    }
}