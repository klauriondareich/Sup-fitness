package com.example.fitnessapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.fitnessapp.Model.Weights
import com.example.fitnessapp.R

class getWeightsAdapter(context: Context, allWeights: List<Weights>) : BaseAdapter(){

    val context =  context
    val allWeights = allWeights

    override fun getCount(): Int {
        return allWeights.count()
    }

    override fun getItem(position: Int): Any {
        return allWeights[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val weightView: View

        weightView = LayoutInflater.from(context).inflate(R.layout.weight_list_item, null)
        val weightDate: TextView = weightView.findViewById(R.id.date_id)
        val weightText: TextView = weightView.findViewById(R.id.text_weight_id)
        val weightPosition = allWeights[position]

        weightDate.text = weightPosition.date
        weightText.text = weightPosition.weight

        return weightView
    }

}