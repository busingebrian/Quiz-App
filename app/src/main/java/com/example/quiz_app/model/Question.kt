package com.example.quiz_app.model

data class Question(
    val id: Int,
    val question: String,
    val image: Int ,// type is int since they are to be stored in the drawable and the drawable uses int
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)
