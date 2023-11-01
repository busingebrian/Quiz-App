package com.example.quiz_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.quiz_app.R
import com.example.quiz_app.model.Question

class QuestionsActivity : AppCompatActivity() {
    private lateinit var progressBar : ProgressBar
    private lateinit var textViewProgress : TextView
    private lateinit var textViewQuestion : TextView
    private lateinit var flagImage : ImageView

    private lateinit var textViewOptionOne : TextView
    private lateinit var textViewOptionTwo : TextView
    private lateinit var textViewOptionThree : TextView
    private lateinit var textViewOptionFour : TextView

    private lateinit var checkButton : Button

    private val currentPosition = 1
    private lateinit var questionList : MutableList<Question>
    private val selectedOptionPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        progressBar = findViewById(R.id.progressBar)
        textViewProgress = findViewById(R.id.text_view_progressBar)
        textViewQuestion = findViewById(R.id.text_view_questions)
        flagImage = findViewById(R.id.image_view)

        textViewOptionOne = findViewById(R.id.text_view_option_one)
        textViewOptionTwo = findViewById(R.id.text_view_option_two)
        textViewOptionThree = findViewById(R.id.text_view_option_three)
        textViewOptionFour = findViewById(R.id.text_view_option_four)

        checkButton = findViewById(R.id.button_check)

        questionList = com.example.quiz_app.utils.Constants.getQuestions()
        Log.d("QuestionSize", "${questionList.size}")
        setQuestion()
    }

    private fun setQuestion(){
        val question = questionList[currentPosition -1]
        flagImage.setImageResource(question.image)
        progressBar.progress = currentPosition
        textViewProgress.text = "$currentPosition/${progressBar.max}"
        textViewQuestion.text = question.question
        textViewOptionOne.text = question.optionOne
        textViewOptionTwo.text = question.optionTwo
        textViewOptionThree.text = question.optionThree
        textViewOptionFour.text = question.optionFour
    }
}