package com.example.fitnessapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.example.fitnessapp.Model.Weights
import com.example.fitnessapp.adapters.getWeightsAdapter
import com.example.fitnessapp.services.helper
import kotlin.collections.ArrayList

class viewWeightActivity : AppCompatActivity() {

    lateinit var adapter : getWeightsAdapter

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_weight)

        var helper = helper(applicationContext)
        var db = helper.readableDatabase

       // val clearDBQuery = "DELETE FROM WEIGHTS"
        //db.execSQL(clearDBQuery)

        var rs = db.rawQuery("SELECT * FROM WEIGHTS ORDER BY date DESC", null)
        val empList:ArrayList<Weights> = ArrayList()

        var userWeight:String
        var userDate:String

        if (rs.moveToFirst()) {
            do {
                userWeight = rs.getString(rs.getColumnIndex("userWeight")) + "KG"
                userDate = rs.getString(rs.getColumnIndex("date"))
                 val userInfos= Weights(date = userDate, weight = userWeight)
                empList.add(userInfos)
            } while (rs.moveToNext())

            // Passing data to the list view
            adapter = getWeightsAdapter(this, empList)
            val weightlistView = findViewById<ListView>(R.id.weightListView)

            weightlistView.adapter = adapter

        }



        // Managing Dialog view
        val addWeight = findViewById<Button>(R.id.add_weight_btn_id)
        addWeight.setOnClickListener(){

            var dialog = CustomDialogFragment()
            dialog.show(supportFragmentManager, "myDialog")

        }
    }

}