package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quiz_app.ui.QuestionsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.button_start)
        val editTextName: EditText = findViewById(R.id.name)

        startButton.setOnClickListener {
            if (editTextName.text.isNotEmpty()){
                Intent(this@MainActivity,QuestionsActivity::class.java).also {
                    startActivity(it)
                    finish() // removes the back action
                }
            }else {
                Toast.makeText(this@MainActivity,"Please enter your Name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}