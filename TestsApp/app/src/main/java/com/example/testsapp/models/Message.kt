package com.example.testsapp.models

import java.util.Date

data class Message(
    val id: String,
    var author_id: String,
    var chat_id: String,
    var content: String,
    var datetime: Long
)
