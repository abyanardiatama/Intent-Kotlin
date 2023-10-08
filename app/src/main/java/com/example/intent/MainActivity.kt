package com.example.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //Membuat Launcher RegisterForActivityResult untuk menerima nilai balik
    private lateinit var textResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivty.RESULT_CODE && result.data != null){
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivty.SELECTED_VALUE, 0)
            textResult.text = "Result Activity : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Berpindah Activity
        val btn_move_activity: Button = findViewById(R.id.btn_move_activity)
        btn_move_activity.setOnClickListener(this)

        //Berpindah Activity dengan data
        val btn_move_activity_data: Button = findViewById(R.id.btn_move_activity_data)
        btn_move_activity_data.setOnClickListener(this)

        //Berpindah Activity dengan object
        val btn_move_activity_object: Button = findViewById(R.id.btn_move_activity_object)
        btn_move_activity_object.setOnClickListener(this)

        //Dial A Number
        val btn_dial_number: Button = findViewById(R.id.btn_dial_number)
        btn_dial_number.setOnClickListener(this)

        //Open Camera
        val btn_open_camera: Button = findViewById(R.id.btn_open_camera)
        btn_open_camera.setOnClickListener(this)

        //Berpindah Activity dengan Result
        val btn_move_for_result: Button = findViewById(R.id.btn_move_for_result)
        btn_move_for_result.setOnClickListener(this)
        textResult = findViewById(R.id.text_result)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            //Berpindah Activity
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            //Berpindah Activity dengan data
            R.id.btn_move_activity_data -> {
                val moveActivityWithData = Intent(this@MainActivity, MoveActivityWithData::class.java)
                moveActivityWithData.putExtra(MoveActivityWithData.NAME, "Abyan Ardiatama")
                moveActivityWithData.putExtra(MoveActivityWithData.AGE, 21)
                startActivity(moveActivityWithData)
            }

            //Berpindah Activity dengan object
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Abyan Ardiatama",
                    21,
                    "ardiatamaabyan@gmail.com",
                    "Semarang"
                )
                val moveActivityWithObject = Intent(this@MainActivity, MoveActivityWithObject::class.java)
                moveActivityWithObject.putExtra(MoveActivityWithObject.PERSON, person)
                startActivity(moveActivityWithObject)
            }

            //Dial A Number
            R.id.btn_dial_number -> {
                val phoneNumber = "0895359747200"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            //Open Camera
            R.id.btn_open_camera -> {
                val openCameraIntent = Intent("android.media.action.IMAGE_CAPTURE")
                startActivity(openCameraIntent)
            }

            //Berpindah Activity dengan Result
            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivty::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }
}