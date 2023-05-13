package com.example.testsapp.models

import java.util.*

data class TestMode(
    val id: Int,
    var name: String,
    var description: String,
    var isReturn: Boolean,
    var isTimeForAnswer: Boolean,
    var canBeTest: Boolean,
    var canBeQuiz: Boolean
)
