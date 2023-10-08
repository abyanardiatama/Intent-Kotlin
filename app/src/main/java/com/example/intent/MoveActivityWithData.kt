package com.example.intent

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MoveActivityWithData : AppCompatActivity() {

    //Data
    companion object {
        const val AGE = "age"
        const val NAME = "name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val textDataReceivedName: Button = findViewById(R.id.text_data_received_name)
        val textDataReceivedAge: Button = findViewById(R.id.text_data_received_age)

        val name = intent.getStringExtra(NAME)
        val age = intent.getIntExtra(AGE, 0)

        val textName = "$name"
        val textAge = "$age"

        textDataReceivedName.text = textName
        textDataReceivedAge.text = textAge
    }
}