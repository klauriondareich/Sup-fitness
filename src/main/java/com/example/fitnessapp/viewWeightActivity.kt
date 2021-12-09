package com.example.fitnessapp

import android.annotation.SuppressLint
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.example.fitnessapp.Model.Weights
import com.example.fitnessapp.adapters.getWeightsAdapter
import com.example.fitnessapp.services.DataService
import com.example.fitnessapp.services.helper

class viewWeightActivity : AppCompatActivity() {

    lateinit var adapter : getWeightsAdapter

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_weight)

        var helper = helper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM WEIGHTS ", null)
        val empList:ArrayList<Weights> = ArrayList()

        var userWeight:String
        var userDate:String

        if (rs.moveToFirst()) {
            do {
                userWeight = rs.getString(rs.getColumnIndex("userWeight"))
                userDate = rs.getString(rs.getColumnIndex("date"))
                 val userInfos= Weights(date = userDate, weight = userWeight)
                empList.add(userInfos)
            } while (rs.moveToNext())

            // Passing data to the list view
            adapter = getWeightsAdapter(this, empList)
            val weightlistView = findViewById<ListView>(R.id.weightListView)

            weightlistView.adapter = adapter
        }
        Log.i("info32", empList.toString())

        /*if (rs.moveToNext()){
            var name = rs.getString(1)

            Log.i("info30", name)
        }*/




        // Managing Dialog view
        val addWeight = findViewById<Button>(R.id.add_weight_btn_id)
        addWeight.setOnClickListener(){

            var dialog = CustomDialogFragment()
            dialog.show(supportFragmentManager, "myDialog")

        }
    }

}