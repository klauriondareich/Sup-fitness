package com.example.fitnessapp

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.fitnessapp.services.helper
import java.text.SimpleDateFormat
import java.util.*


class CustomDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rootView: View = inflater.inflate(R.layout.fragment_custom_dialog, container, false)
        // Inflate the layout for this fragment

        // Database Init
        var helper = helper(requireActivity().application)
        var db = helper.readableDatabase

        // Getting inputs and buttons components
        val submitBtn = rootView.findViewById<Button>(R.id.submitButton)
        val weightInput = rootView.findViewById<TextView>(R.id.enter_weight_id)

        submitBtn.setOnClickListener(){
            var cv = ContentValues()
            val currentDate: String = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(
                Date()
            )
            cv.put("userWeight", weightInput.getText().toString())
            cv.put("date", currentDate)
            db.insert("weights", null, cv)

            weightInput.setText("")
            getActivity()?.recreate();
            dismiss()
        }

        return rootView
    }


}