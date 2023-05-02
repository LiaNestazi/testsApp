package com.example.testsapp.models

data class Comment(
    val id: String,
    var user_id: String,
    var test_id: String,
    var content: String
)
