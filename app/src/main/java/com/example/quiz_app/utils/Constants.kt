package com.example.quiz_app.utils

import com.example.quiz_app.R
import com.example.quiz_app.model.Question

object Constants {
    fun getQuestions(): MutableList<Question> {
        val questions = mutableListOf<Question>()
        val quest1 = Question(
            1, "What country does this flag represent?", R.drawable.flag_of_andorra,
            "Uganda", "Kenya", "Andora", "Barbadus",
            3
        )
        questions.add(quest1)

        val quest2 = Question(
            1, "What country does this flag represent?", R.drawable.flag_of_argentina,
            "Uganda", "Kenya", "Andora", "Argentina",
            4
        )
        questions.add(quest2)

        val quest3 = Question(
            1, "What country does this flag represent?", R.drawable.flag_of_kenya,
            "Uganda", "Kenya", "Andora", "Argentina",
            2
        )
        questions.add(quest3)

        val quest4 = Question(
            1, "What country does this flag represent?", R.drawable.flag_of_tanzania,
            "Tanzania", "Kenya", "Andora", "Argentina",
            1
        )
        questions.add(quest4)

        val quest5 = Question(
            1, "What country does this flag represent?", R.drawable.flag_of_haiti,
            "Tanzania", "Kenya", "Andora", "Haiti",
            4
        )
        questions.add(quest5)

        val quest6 = Question(
            1, "What country does this flag represent?", R.drawable.flag_of_mozambique,
            "Mozambique", "Kenya", "Andora", "Haiti",
            1
        )
        questions.add(quest6)

        val quest7 = Question(
            1, "What country does this flag represent?", R.drawable.uganda,
            "Uganda", "Kenya", "Japan", "Haiti",
            1
        )
        questions.add(quest7)

        val quest8 = Question(
            1, "What country does this flag represent?", R.drawable.flag_of_syria,
            "Syria", "Kenya", "Japan", "Haiti",
            1
        )
        questions.add(quest8)

        val quest9 = Question(
            1, "What country does this flag represent?", R.drawable.flag_of_barbados,
            "Barbadus", "Kenya", "Japan", "Haiti",
            1
        )
        questions.add(quest9)

        val quest10 = Question(
            1, "What country does this flag represent?", R.drawable.flag_of_south_sudan,
            "Barbadus", "Kenya", "Republic of South Sudan", "Haiti",
            3
        )
        questions.add(quest10)

        return questions
    }
}