package com.example.quiz_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.util.Log
import com.example.quiz_app.R

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        val questionList = com.example.quiz_app.utils.Constants.getQuestions()
        Log.d("QuestionSize", "${questionList.size}")
    }
}