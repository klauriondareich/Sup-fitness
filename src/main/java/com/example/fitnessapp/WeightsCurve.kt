package com.example.fitnessapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessapp.Model.datesForCurve
import com.example.fitnessapp.Model.weightsForCurve
import com.example.fitnessapp.services.helper
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet






class WeightsCurve : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weights_curve)

        // Database initialisation
        var helper = helper(applicationContext)
        var db = helper.readableDatabase

        // Select all weights from DB by Date
        var rs = db.rawQuery("SELECT * FROM WEIGHTS ORDER BY date DESC", null)
        val datesList:ArrayList<datesForCurve> = ArrayList()
        val weightsList:ArrayList<weightsForCurve> = ArrayList()

        var userWeight:String
        var userDate:String

        if (rs.moveToFirst()) {
            do {
                userWeight = rs.getString(rs.getColumnIndex("userWeight"))
                userDate = rs.getString(rs.getColumnIndex("date"))

                val dates= datesForCurve(date = userDate)
                datesList.add(dates)

                val weights = weightsForCurve(weight = userWeight)
                weightsList.add(weights)

                displayValuesInChart(datesList, weightsList)

            } while (rs.moveToNext())

        }


    }

    fun displayValuesInChart(datesList:ArrayList<datesForCurve>, weightsList:ArrayList<weightsForCurve>){

        val xvalue = ArrayList<String>()
        val lineentry = ArrayList<Entry>()

        for (item in datesList) {
            xvalue.add(item.toString())
        }

        var nb = 0

        for (elt in weightsList) {
            lineentry.add(Entry(elt.toFloat() ,nb))
            nb = nb + 1
        }

        val linedataset = LineDataSet(lineentry, "Courbe de poids")

        val data = LineData(xvalue, linedataset)

        val lineChart = findViewById<LineChart>(R.id.lineChart)
        lineChart.data = data
        lineChart.animateXY(3000, 3000)
        lineChart.invalidate()
    }

    fun convertFloat(value1: weightsForCurve): Float {
            return value1.toFloat()
    }

}