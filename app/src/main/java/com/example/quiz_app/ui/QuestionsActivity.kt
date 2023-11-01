package com.example.quiz_app.ui

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quiz_app.R
import com.example.quiz_app.model.Question

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressBar: ProgressBar
    private lateinit var textViewProgress: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var flagImage: ImageView

    private lateinit var textViewOptionOne: TextView
    private lateinit var textViewOptionTwo: TextView
    private lateinit var textViewOptionThree: TextView
    private lateinit var textViewOptionFour: TextView

    private lateinit var checkButton: Button

    private var currentPosition = 0
    private lateinit var questionList: MutableList<Question>
    private var selectedOptionScore = 0
    private var selectedAnswer = 0
    private lateinit var currentQuestion: Question
    private var answered = false

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

        textViewOptionOne.setOnClickListener(this)
        textViewOptionTwo.setOnClickListener(this)
        textViewOptionThree.setOnClickListener(this)
        textViewOptionFour.setOnClickListener(this)
        checkButton.setOnClickListener(this)

        checkButton = findViewById(R.id.button_check)

        questionList = com.example.quiz_app.utils.Constants.getQuestions()
        Log.d("QuestionSize", "${questionList.size}")
        showNextQuestion()
    }

    private fun showNextQuestion() {


        if (currentPosition < questionList.size) {
            currentQuestion = questionList[currentPosition]
            checkButton.text = "CHECK"
            resetOptions()
            val question = questionList[currentPosition]
            flagImage.setImageResource(question.image)
            progressBar.progress = currentPosition
            textViewProgress.text = "${currentPosition+1 }/${progressBar.max}"
            textViewQuestion.text = question.question
            textViewOptionOne.text = question.optionOne
            textViewOptionTwo.text = question.optionTwo
            textViewOptionThree.text = question.optionThree
            textViewOptionFour.text = question.optionFour
        } else {
            checkButton.text = "FINISH"
        }

        currentPosition ++
        answered = false
    }

    private fun resetOptions() {
        val options = mutableListOf<TextView>()
        options.add(textViewOptionOne)
        options.add(textViewOptionTwo)
        options.add(textViewOptionThree)
        options.add(textViewOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.bkgd
            )
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.text_view_option_one -> {
                selectedOption(textViewOptionOne, 1)
            }

            R.id.text_view_option_two -> {
                selectedOption(textViewOptionTwo, 2)
            }

            R.id.text_view_option_three -> {
                selectedOption(textViewOptionThree, 3)
            }

            R.id.text_view_option_four -> {
                selectedOption(textViewOptionFour, 4)
            }

            R.id.button_check -> {
                if (!answered) {
                    checkAnswer()
                } else {
                    showNextQuestion()
                }
                selectedAnswer = 0
            }
        }
    }
    private fun selectedOption(textView: TextView, selectedOptionNumber: Int) {
        resetOptions()
        selectedAnswer = selectedOptionNumber

        textView.setTextColor(Color.parseColor("#6D5D6E"))
            textView.setTypeface(textView.typeface, Typeface.BOLD)
            textView.background = ContextCompat.getDrawable(
                this, R.drawable.selected_border_bkgd
            )
        }

        private fun checkAnswer() {
            answered = true
            if (selectedAnswer == currentQuestion.correctAnswer) {

                selectedOptionScore ++

                when (selectedAnswer) {
                    1 -> {
                        textViewOptionOne.background =
                            ContextCompat.getDrawable(this, R.drawable.correct_bkgd)
                    }

                    2 -> {
                        textViewOptionTwo.background =
                            ContextCompat.getDrawable(this, R.drawable.correct_bkgd)
                    }

                    3 -> {
                        textViewOptionThree.background =
                            ContextCompat.getDrawable(this, R.drawable.correct_bkgd)
                    }

                    4 -> {
                        textViewOptionFour.background =
                            ContextCompat.getDrawable(this, R.drawable.correct_bkgd)
                    }
                }
            } else {
            when (selectedAnswer) {
                1 -> {
                    textViewOptionOne.background = ContextCompat.getDrawable(
                        this,
                        R.drawable.incorrect_bkgd
                    )
                }

                2 -> {
                    textViewOptionTwo.background =
                        ContextCompat.getDrawable(this, R.drawable.incorrect_bkgd)
                }

                3 -> {
                    textViewOptionThree.background =
                        ContextCompat.getDrawable(this, R.drawable.incorrect_bkgd)
                }

                4 -> {
                    textViewOptionFour.background =
                        ContextCompat.getDrawable(this, R.drawable.incorrect_bkgd)
                }
            }
        }
        checkButton.text = "NEXT"
            showSolution()
    }

    private fun showSolution() {
        selectedAnswer = currentQuestion.correctAnswer
        when(selectedAnswer){
            1 -> {
                textViewOptionOne.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_bkgd)
            }

            2 -> {
                textViewOptionTwo.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_bkgd)
            }

            3 -> {
                textViewOptionThree.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_bkgd)
            }

            4 -> {
                textViewOptionFour.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_bkgd)
            }
        }
    }
}