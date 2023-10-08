package com.example.intent

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveActivityWithObject : AppCompatActivity() {

    //Object Person
    companion object{
        const val PERSON = "person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        //Deklarasi TextView
        val textObjectReceived: TextView = findViewById(R.id.text_object_received)

        //Menerima data dari MainActivity
        val person = if(Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Person>(PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(PERSON)
        }

        if (person != null){
            val text =  "Name : ${person.name.toString()}\n" +
                        "Email : ${person.email.toString()}\n" +
                        "Age : ${person.age}\n" +
                        "Location : ${person.city.toString()}"
            textObjectReceived.text = text
        }
    }
}