package com.example.fitnessapp.services

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class helper (context: Context) : SQLiteOpenHelper(context,"FitnessDB", null, 1){

    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE WEIGHTS(userId INTEGER PRIMARY KEY AUTOINCREMENT, userWeight TEXT, date TEXT)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}